package com.april2nd.live1;

import com.april2nd.live1.interceptor.SessionInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication

@MapperScan(basePackages = {"com.april2nd.live1.model.dao"})
public class Live1Application implements WebMvcConfigurer {
    @Autowired
    SessionInterceptor sessionInterceptor;

    // 인터셉터 설정 추가
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/book/regist");
        // addPathPatterns를 계속 추가할 수 있다.
    }
    public static void main(String[] args) {
        SpringApplication.run(Live1Application.class, args);
    }

}
