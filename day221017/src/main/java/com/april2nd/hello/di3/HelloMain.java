package com.april2nd.hello.di3;

public class HelloMain {
    public static void main(String[] args) {
        HelloMessage hello = HelloMessageFactory.getHelloMessage("eng");
        String greeting = hello.hello("김준호");
        System.out.println(greeting);
    }
}
