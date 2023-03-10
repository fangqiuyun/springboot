package com.junmooo.springbootdemo.config;

import com.junmooo.springbootdemo.interceptor.AdminInterceptor;
import com.junmooo.springbootdemo.interceptor.ClientInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    AdminInterceptor adminInterceptor;

    @Autowired
    ClientInterceptor clientInterceptor;
    /**
     * 添加Web项目的拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 对所有访问路径，都通过MyInterceptor类型的拦截器进行拦截
        registry.addInterceptor(adminInterceptor).addPathPatterns("/auth/**")
                .excludePathPatterns("/", "/auth/login", "/auth/register", "/auth/getName");
        //放行登录页，登陆操作，静态资源
        registry.addInterceptor(clientInterceptor).addPathPatterns("/message/**","/hello/**");

    }
}