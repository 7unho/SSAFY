package com.april2nd.live1;

import org.springframework.stereotype.Component;

@Component("m2")
public class MyImpl2 implements My{
    @Override
    public void run() {
        System.out.println("전력 질주!!");
    }
}
