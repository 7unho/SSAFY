package com.april2nd.vueapi.vue.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
		basePackages = "com.april2nd.vueapi.vue.model.mapper"
)
public class DatabaseConfiguration {}