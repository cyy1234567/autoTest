package com.interceptor;

import com.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.List;


@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }
    @Bean
    public AutoInterceptor autoInterceptor(){
        return new AutoInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录拦截的管理器
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**") //所有路径都被拦截
                //添加不拦截路径
                .excludePathPatterns("/login","/error",
                        "/static/**","/logout", Constant.AnonymousURL_Prefix+"/**");

        //接下来是权限拦截器
        registry.addInterceptor(autoInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/error",
                        "/static/**","/logout", Constant.AnonymousURL_Prefix+"/**", Constant.commonURL_Prefix+"/**");


    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
