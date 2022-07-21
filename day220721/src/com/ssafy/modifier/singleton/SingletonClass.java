package com.ssafy.modifier.singleton;

public class SingletonClass {
    private static SingletonClass instance = new SingletonClass();
    private SingletonClass(){}

    public static SingletonClass getInstance(){
        return instance;
    }

    public void sayHello() {
        System.out.println("Hello");
    }
}