package com.april2nd.live1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        A a = context.getBean("a",A.class);
        a.hello();

        B b = context.getBean("b", B.class);
        b.good();

        Food food = context.getBean(Food.class);
        food.eat();
    }
}
