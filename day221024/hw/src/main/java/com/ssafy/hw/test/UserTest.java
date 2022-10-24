package com.ssafy.hw.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.hw.model.dao.UserDao;
import com.ssafy.hw.model.dto.User;

public class UserTest {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

    }
}
