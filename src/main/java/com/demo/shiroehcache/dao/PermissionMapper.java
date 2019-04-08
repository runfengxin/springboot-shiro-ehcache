package com.demo.shiroehcache.dao;

import com.alibaba.fastjson.JSONObject;
import com.demo.shiroehcache.pojo.Permission;
import com.demo.shiroehcache.util.MyMapper;

import java.util.Set;

public interface PermissionMapper extends MyMapper<Permission> {

    /**
     * @Author xin.rf
     * @Date 2018/11/19 17:58
     * @Description 查询用户的角色 菜单 权限
     */
    JSONObject getUserPermission(String username);


    Set<String> getAllMenu();

    Set<String> getAllPermission();
}