package com.demo.shiroehcache.controller;

import com.demo.shiroehcache.common.Result;
import com.demo.shiroehcache.pojo.User;
import com.demo.shiroehcache.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ApiOperation(value = "注册", notes = "注册")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", required = true),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true),
    })
    public Result register(User user) {
        userService.register(user);
        return Result.ok();
    }

    @RequestMapping(value = "auth",method = RequestMethod.POST)
    @ApiOperation(value = "登录认证", notes = "登录认证")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", value = "邮箱", required = true),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true)
    })
    public Result authLogin(String username, String password) {
        Result result=userService.authLogin(username,password);
        return result;
    }

    @RequestMapping(value = "getUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public Result getUserInfo() {
        Result result=userService.getUserInfo();
        return result;
    }
    
}
