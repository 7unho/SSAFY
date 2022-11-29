package com.april2nd.happyhouse.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
		basePackages = "com.april2nd.happyhouse.model.mapper"
)
public class DatabaseConfiguration {}