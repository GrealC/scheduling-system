package com.example.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.common.Result;
import com.example.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override//目标资源放行前运行
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        //  1.获取请求url
        String url=req.getRequestURL().toString();
        //2.判断是否是登录注册，是则放行
        if(url.contains("login") || url.contains("register") || url.contains("findCode")){
            return true;
        }
        //3.获取令牌token
        String jwt = req.getHeader("token");

        //4.判断令牌是否存在，不存在则返回错误信息（未登录）
        if(!StringUtils.hasLength(jwt)){
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象---》json
            String notLogin= JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }
        //5.解析token,如果解析失败，返回错误信息（未登录）
        try{
            JwtUtils.parseJWT(jwt);
        } catch (Exception e){
            e.printStackTrace();
            Result error = Result.error("NOT_LOGIN");
            String notLogin= JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }
        //6.放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterComp..");
    }
}
