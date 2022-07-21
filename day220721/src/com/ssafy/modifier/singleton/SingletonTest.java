package com.ssafy.modifier.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        SingletonClass sc1 = SingletonClass.getInstance();
        SingletonClass sc2 = SingletonClass.getInstance();

        System.out.printf("두 객체는 같은가? %b\n", sc1, sc2);
        sc1.sayHello();
    }
}
