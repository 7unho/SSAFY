package com.ssafy.modifier.Encapsulation;

public class BelievableTest {
    public static void main(String[] args) {
        UnbelievableuserInfo info = new UnbelievableuserInfo();

        System.out.printf("사용자 정보 : %s, %d\n", info.getName(), info.getAccount());
        info.setName(null);
        info.setAccount(-1000);
        System.out.printf("사용자 정보 : %s, %d\n", info.getName(), info.getAccount());
    }
}
