package com.april2nds.boj;

import java.util.Scanner;

public class BOJ_2839_설탕배달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;

        while(true){
            if(N % 5 == 0){
                answer += N / 5;
                break;
            }

            N -= 3;
            answer += 1;

            if(N < 0) {
                answer = -1;
                break;
            }
        }

        System.out.println(answer);
    }
}
