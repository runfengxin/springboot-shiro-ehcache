package com.demo.shiroehcache.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.demo.shiroehcache.common.CodeException;
import com.demo.shiroehcache.common.Constants;
import com.demo.shiroehcache.common.ErrorEnum;
import com.demo.shiroehcache.common.Result;
import com.demo.shiroehcache.dao.UserMapper;
import com.demo.shiroehcache.pojo.User;
import com.demo.shiroehcache.service.PermissionService;
import com.demo.shiroehcache.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermissionService permissionService;

    @Override
    public User getOne(User user) {
        User user1=userMapper.selectOne(user);
        return user1;
    }

    @Override
    public void register(User user) {
        String salt1 = user.getUsername();
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        String password = new SimpleHash("MD5", user.getPassword(), salt1+salt2, 1024).toHex();
        user.setPassword(password);
        user.setSalt(salt2);
        userMapper.insertSelective(user);
    }

    @Override
    public Result authLogin(String username, String password) {
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);
        } catch (ExcessiveAttemptsException eae){
            throw new CodeException(ErrorEnum.PASSWORD_ERROR_MORE_THAN_FIVE);
        } catch (AuthenticationException e) {
            throw new CodeException(ErrorEnum.USERNAME_PASSWORD_ERROR);
        }
        User user=new User();
        user.setUsername(String.valueOf(token.getPrincipal()));
        User tUser= userMapper.selectOne(user);
        tUser.setPassword(null);
        return Result.ok(tUser);
    }

    @Override
    public Result getUserInfo() {
        Session session = SecurityUtils.getSubject().getSession();
        User tUser= (User) session.getAttribute(Constants.SESSION_USER_INFO);
        String email = tUser.getUsername();
        JSONObject userPermission = permissionService.getUserPermission(email);
        session.setAttribute(Constants.SESSION_USER_PERMISSION, userPermission);
        return Result.ok(userPermission);
    }
}
