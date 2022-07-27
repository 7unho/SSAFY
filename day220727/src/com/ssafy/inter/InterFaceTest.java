package com.ssafy.inter;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;

public class InterFaceTest {
    public static void main(String[] args) {
//        MenuPan mp = new MenuPan(); => interface는 객체 생성 X
        MenuPan menuPan;

        // 기본 : 부모 레퍼런스 통해 자식 호출 X
        menuPan = new HongKong();

        menuPan.짜장면();

        // 초밥 호출
        // 1. 메소드 내에 호출문을 넣기.
        menuPan.짬뽕();

        // 2. 캐스팅해서 호출하기
        ((HongKong)menuPan).초밥();

    }
}
