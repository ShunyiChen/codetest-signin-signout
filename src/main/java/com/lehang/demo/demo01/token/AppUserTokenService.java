package com.lehang.demo.demo01.token;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lehang.demo.demo01.appuser.AppUser;
import com.lehang.demo.demo01.appuser.AppUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserTokenService extends ServiceImpl<AppUserTokenMapper, AppUserToken> {

    @Autowired
    private AppUserTokenMapper appUserTokenMapper;

    public boolean doesTokenExist(String token) {
        QueryWrapper<AppUserToken> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("token", token);
        return appUserTokenMapper.selectCount(queryWrapper) > 0;
    }

    public List<AppUserToken> findAllTokens() {
        QueryWrapper<AppUserToken> queryWrapper = new QueryWrapper<>();
        return appUserTokenMapper.selectList(queryWrapper);
    }

    public AppUserToken createNewUserToken(String token) {
        AppUserToken newToken = new AppUserToken();
        newToken.setToken(token);
        appUserTokenMapper.insert(newToken);
        return newToken;
    }

    public void deleteUserToken(String token) {
        QueryWrapper<AppUserToken> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("token", token);
        appUserTokenMapper.delete(queryWrapper);
    }

}
