package com.lehang.demo.demo01.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lehang.demo.demo01.appuser.AppUser;
import com.lehang.demo.demo01.appuser.AppUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AppUserMapper appUserMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		QueryWrapper<AppUser> wapper = new QueryWrapper<>();
		wapper.eq("username", username);
		List<AppUser> users = appUserMapper.selectList(wapper);
		if (users == null || users.size() == 0) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		AppUser user = users.get(0);
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(),
				user.getPassword(),
				true,
				true,
				true,
				true,
				getAuthorities(user.isAdmin()?"admin":"user"));
	}

	private List<SimpleGrantedAuthority> getAuthorities(String role) {
		List<SimpleGrantedAuthority> authList = new ArrayList<>();
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));

		//you can also add different roles here
		//for example, the user is also an admin of the site, then you can add ROLE_ADMIN
		//so that he can view pages that are ROLE_ADMIN specific
		if (role != null && role.trim().length() > 0) {
			if (role.equals("admin")) {
				authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			}
		}
		return authList;
	}
}