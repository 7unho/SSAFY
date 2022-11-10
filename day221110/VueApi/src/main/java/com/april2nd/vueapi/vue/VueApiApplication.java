package com.april2nd.vueapi.vue;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VueApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VueApiApplication.class, args);
	}

}
