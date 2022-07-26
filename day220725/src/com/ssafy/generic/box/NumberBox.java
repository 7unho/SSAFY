package com.ssafy.generic.box;

// T는 Number 또는 Number 를 상속 받은 타입이다.
public class NumberBox<T extends Number> {

    // T는 최소한 Number 의 기능은 사용할 수 있다.
    public void addSome(T... ts){
        double sum = 0;
        for (T t :ts) {
            sum += t.doubleValue();
        }
        System.out.println(sum);
    }
}
