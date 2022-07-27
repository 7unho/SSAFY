package com.ssafy.inter;

public class HongKong implements MenuPan {
    @Override
    public void 짜장면() {
        System.out.println("달콤한 짜장면 ~");
    }

    @Override
    public void 짬뽕() {
        System.out.println("매콤한 짬뽕 @");
        초밥();
    }

    @Override
    public void 볶음밥() {
        System.out.println("");
    }

    public void 초밥(){
        System.out.println("한입에 쏘옥 !");
    }
}
