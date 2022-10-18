package com.april2nd.hello.di4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloMessage hello = (HelloMessage)context.getBean("eng");
        String greeting = hello.hello("김준호");
        System.out.println(greeting);
    }
}
