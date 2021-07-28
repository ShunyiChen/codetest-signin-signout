package com.lehang.demo.demo01.appuser;

import com.lehang.demo.demo01.config.JwtTokenUtil;
import com.lehang.demo.demo01.config.JwtUserDetailsService;
import com.lehang.demo.demo01.token.AppUserToken;
import com.lehang.demo.demo01.token.AppUserTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppUserTokenService appUserTokenService;

	@GetMapping(value = "/getusers")
	public ResponseEntity<?> getAllUsers() {
		List<AppUser> list = appUserService.findAllUsers();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/gettokens")
	public ResponseEntity<?> getAllTokens() {
		List<AppUserToken> list = appUserTokenService.findAllTokens();
		return ResponseEntity.ok(list);
	}

	@PostMapping(value = "/signin")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
		try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		} catch(DisabledException e) {
			return ResponseEntity.ok(JwtResponse.builder().error("用户已禁用"));
		} catch(BadCredentialsException e) {
			return ResponseEntity.ok(JwtResponse.builder().error("用户名或密码错误"));
		}
		final UserDetails userDetails = jwtUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		//Save token to database
		appUserTokenService.createNewUserToken(token);

		return ResponseEntity.ok(new JwtResponse(
				token,
				userDetails,
				new Date(), ""));
	}

	private void authenticate(String username, String password) throws DisabledException, BadCredentialsException {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}

	@PostMapping(value = "/signup")
	public ResponseEntity<?> saveUser(@RequestBody AppUser user) {
		log.info("成功注册了一位用户");
		return ResponseEntity.ok(appUserService.createNewUser(user));
	}

	@PostMapping(value = "/signout")
	public ResponseEntity<?> logout(@RequestParam String token) {
		try {
			String userName = jwtTokenUtil.getUsernameFromToken(token);
			if(appUserTokenService.doesTokenExist(token)) {
				appUserTokenService.deleteUserToken(token);
			}
			log.info("用户"+userName+"已成功退出");
		} catch (Exception e) {
			log.info("用户退出异常:\n"+e);
		}
		return ResponseEntity.ok("You have logged out successfully");
	}

}