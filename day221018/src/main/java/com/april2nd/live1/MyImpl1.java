package com.april2nd.live1;

import org.springframework.stereotype.Component;

@Component("m1")
public class MyImpl1 implements My{
    @Override
    public void run() {
        System.out.println("깡총 깡총!!");
    }
}
