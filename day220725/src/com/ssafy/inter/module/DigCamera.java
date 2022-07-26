package com.ssafy.inter.module;

public class DigCamera extends Camera implements Chargeable{
    @Override
    public void charge() {
        System.out.println("디카 충전");
    }
}
