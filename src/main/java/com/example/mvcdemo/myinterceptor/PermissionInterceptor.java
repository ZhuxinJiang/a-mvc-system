package com.example.mvcdemo.myinterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PermissionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("PermissionInterceptor----preHandle 方法执行");
        String user = (String) request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("msg", "未经登录，不允许访问，请先登录！");
            request.getRequestDispatcher("/WEB-INF/jsp/prelogin.jsp").forward(request, response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("PermissionInterceptor----postHandle 方法执行");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("PermissionInterceptor----afterCompletion 方法执行");

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
