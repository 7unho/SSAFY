package com.april2nd.hello.di1;

public class HelloMain {
    public static void main(String[] args) {
        HelloMessageKor kr = new HelloMessageKor();
        String greeting = kr.helloKor("김준호");

        HelloMessageEng eng = new HelloMessageEng();
        String greeting_eng = eng.helloEng("김준호");
        System.out.println(greeting);
        System.out.println(greeting_eng);
    }
}
