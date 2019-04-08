package com.demo.shiroehcache.service;

import com.demo.shiroehcache.common.Result;
import com.demo.shiroehcache.pojo.User;

public interface UserService {

    User getOne(User user);

    void register(User user);

    Result authLogin(String username, String password);

    Result getUserInfo();
}
