package com.live.liveteam.common.config;


import com.live.liveteam.common.enums.EnumResult;
import com.live.liveteam.common.exception.BizException;
import com.live.liveteam.common.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;


/**
 * 检验公共参数，以及获取当前用户信息
 */
public class UserTokenInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // TODO 会话拦截，权限验证
        String userToken = request.getHeader("token");
        //如果不在redis中，代表未登录，跳转到登录页
        if (userToken==null) {
            //用户未授权
            throw new BizException(EnumResult.USER_TOKEN_NULL);
        }
        boolean b = redisUtil.hasKey(RedisUtil.LOGIN_USER_STRING + userToken);
        if (!b){
            throw new BizException(EnumResult.USER_NOT_LOGIN);
        }else {
            redisUtil.expire(userToken,RedisUtil.USER_TOKEN_TIME);
        }
        return true;
    }
}