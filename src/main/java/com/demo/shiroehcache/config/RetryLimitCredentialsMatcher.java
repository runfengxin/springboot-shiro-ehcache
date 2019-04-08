package com.demo.shiroehcache.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xin.rf
 * @date 2018/11/20 15:12
 * @Description TODO
 **/
@Component
@Slf4j
public class RetryLimitCredentialsMatcher extends HashedCredentialsMatcher {


    private int maxRetryNum = 5;
    private EhCacheManager shiroEhcacheManager;

    public void setMaxRetryNum(int maxRetryNum) {
        this.maxRetryNum = maxRetryNum;
    }

    public RetryLimitCredentialsMatcher(EhCacheManager shiroEhcacheManager) {
        this.shiroEhcacheManager = shiroEhcacheManager;
    }


    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        Cache<String, AtomicInteger> passwordRetryCache = shiroEhcacheManager.getCache("passwordRetryCache");
        String username = (String) token.getPrincipal();
        //retry count + 1
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if (null == retryCount) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        if (retryCount.incrementAndGet() > maxRetryNum) {
            log.warn("用户[{}]进行登录验证..失败验证超过{}次", username, maxRetryNum);
            throw new ExcessiveAttemptsException("username: " + username + " tried to login more than 5 times in period");
        }
        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            //clear retry data
            passwordRetryCache.remove(username);
        }
        return matches;
    }
}
