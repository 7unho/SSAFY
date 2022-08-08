package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2164_카드2 {
    public static void main(String[] args) throws IOException {

        // byte 입력을 문자로 변환 후, 버퍼에 담아준다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int n = 1;
        while(n < N){
            n *= 2;
        }
        n /= 2;

        System.out.println((N == 1) ? 1 : (N - n) * 2);
    }
}
