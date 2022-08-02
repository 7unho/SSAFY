package com.ssafy.recursive;

public class FactorialTest {
    public static void main(String[] args) {
        int res = fac(5);
        System.out.println(res);
    }

    public static int fac(int n){
        if( n == 1 ) return 1;
        return n * fac(n - 1);
    }
}
