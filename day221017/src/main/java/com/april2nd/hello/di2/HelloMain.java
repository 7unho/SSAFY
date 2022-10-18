package com.april2nd.hello.di2;

public class HelloMain {
    public static void main(String[] args) {
        HelloMessageKor kr = new HelloMessageKor();
        String greeting = kr.hello("김준호");

        HelloMessageEng eng = new HelloMessageEng();
        String greeting_eng = eng.hello("김준호");
        System.out.println(greeting);
        System.out.println(greeting_eng);
    }
}
