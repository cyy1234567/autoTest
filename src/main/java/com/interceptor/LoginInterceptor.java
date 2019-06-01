package com.interceptor;

import com.google.gson.Gson;
import com.util.ResponseEnum;
import com.util.ResponseUtils;
import com.util.URLUtil;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.convert.Bucket;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private RedissonClient redissonClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getServletPath();
        if (!URLUtil.isAnonymousURL(uri)) {
            System.out.println("被登录拦截器拦截" + "===========" + uri);
            boolean resultFlag = false;
            String token = request.getHeader("Token");
            if(token!=null){
                RBucket<String> userKey =
                                redissonClient.getBucket("0001");
                userKey.set("value 0002",60*10, TimeUnit.SECONDS);
                System.out.println(userKey.get()+"================");
            }

            if (!resultFlag) {
                System.out.println(request.getHeader("X-Requested-With"));
                //未通过登录校验  如果是ajax返回错误码，不是则跳往登录界面
                if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
                    response.getWriter().write(new Gson().toJson(ResponseUtils.fail(ResponseEnum.NOT_LOGGED_IN, "")));
                } else {
                    response.sendRedirect("/static/login.html");
                }
            }
            //继续执行请求
            return resultFlag;
        }
        return true;//继续执行请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
