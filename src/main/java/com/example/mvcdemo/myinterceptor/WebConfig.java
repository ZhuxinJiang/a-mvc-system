package com.example.mvcdemo.myinterceptor;

import com.example.mvcdemo.myinterceptor.PermissionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermissionInterceptor())
                .addPathPatterns("/**")   //拦截全部请求
                .excludePathPatterns("/login.do", "/dologin.do" ,"/register.do", "/doregister.do", "/prelogin.do", "/hello.do"); // 哪些请求不需要拦截
    }
}
