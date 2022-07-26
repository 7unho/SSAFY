package com.ssafy.inter.replace;

import com.ssafy.inter.module.Phone;

import java.util.Scanner;

public class CalculatorClient {
    Calculator calcLogic = new CalculatorImpl();

    public void add(){
        System.out.println("첫 번째 정수를 입력하시오 .");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("두 번째 정수를 입력하시오 .");
        int b = sc.nextInt();
        System.out.printf("결과 : %d + %d = %d\n", a, b, calcLogic.add(a, b));
        sc.close();
    }
    public static void main(String[] args) {
        CalculatorClient cc = new CalculatorClient();
        cc.add();
    }
}
