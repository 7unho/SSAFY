package com.april2nd.live1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = {"com.april2nd.live1.model.dao"})
public class Live1Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Live1Application.class, args);
    }

}
