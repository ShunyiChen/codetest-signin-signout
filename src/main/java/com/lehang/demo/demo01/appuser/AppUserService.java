package com.lehang.demo.demo01.appuser;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lehang.demo.demo01.token.AppUserTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Asus
 * @create 2021-07-27 19:20
 */
@Service
public class AppUserService extends ServiceImpl<AppUserMapper, AppUser> {
    @Autowired
    private AppUserMapper appUserMapper;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public List<AppUser> findAllUsers() {
        QueryWrapper<AppUser> queryWrapper = new QueryWrapper<>();
        return appUserMapper.selectList(queryWrapper);
    }

    public AppUser createNewUser(AppUser user) {
        AppUser newUser = new AppUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setAdmin(user.isAdmin());
        appUserMapper.insert(newUser);
        return newUser;
    }
}
