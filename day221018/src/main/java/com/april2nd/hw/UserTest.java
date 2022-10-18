package com.april2nd.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserPrinter printer = context.getBean(UserPrinter.class);
        System.out.println("************** 1. 의존성 주입 ");
        printer.printUserRank();
        System.out.println("************** 2. 싱글톤 확인 ");

        User user1 = context.getBean(VipUser.class);
        User user2 = context.getBean(VipUser.class);
        System.out.println(user1 == user2);
    }
}
