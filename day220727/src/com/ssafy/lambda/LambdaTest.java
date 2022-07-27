package com.ssafy.lambda;

public class LambdaTest {
    public static void main(String[] args) {
        You y = new YouImpl();
        y.run();

        You y2 = new You(){
            @Override
            public void run() {
                System.out.println("선릉역까지 달려보자 !!!");
            }
        };
        y2.run();

        You y3 = () -> {
            System.out.println("역삼역까지 달려보자 !!!");
        };
        y3.run();

    }
}
