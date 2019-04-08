package com.demo.shiroehcache.service;

import com.alibaba.fastjson.JSONObject;

public interface PermissionService {

    JSONObject getUserPermission(String username);
}
