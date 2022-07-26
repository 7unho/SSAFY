package com.ssafy.inter.module;

public class HandPhone extends Phone implements Chargeable{
    @Override
    public void charge() {
        System.out.println("핸드폰 충전");
    }
}
