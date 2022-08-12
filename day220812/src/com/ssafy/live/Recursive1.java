package com.ssafy.live;

public class Recursive1 {
    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            System.out.println(i);
//        }
        int n = 0;
//        while(n < 5){
//            System.out.println(n);
//            n += 1;
//        }
        recursive(n);
    }

    public static void recursive(int n){
        // 기저파트
        if(n == 5) return;


        // 유도파트
        System.out.println(n);
//        recursive(n++); ==> 에러 발생 : StackOverFlowError
//        recursive(++n); //==> 실행 결과는 OK지만 문제 발생 : parameter값과 리턴값의 차이가 발생할 수 있다.
//        System.out.println(">>> : " + n);

        recursive(n + 1);
    }
}
