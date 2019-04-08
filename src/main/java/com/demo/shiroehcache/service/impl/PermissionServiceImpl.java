package com.demo.shiroehcache.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.demo.shiroehcache.dao.PermissionMapper;
import com.demo.shiroehcache.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public JSONObject getUserPermission(String username) {
        JSONObject userPermission = permissionMapper.getUserPermission(username);
        //管理员角色ID为1
        int adminRoleId = 1;
        //如果是管理员
        String roleIdKey = "roleId";
        if (adminRoleId == Integer.parseInt(String.valueOf(userPermission.getIntValue(roleIdKey)))) {
            //查询所有菜单  所有权限
            Set<String> menuList = permissionMapper.getAllMenu();
            Set<String> permissionList = permissionMapper.getAllPermission();
            userPermission.put("menuList",menuList);
            userPermission.put("permissionList",permissionList);
        }
        return userPermission;
    }
}
