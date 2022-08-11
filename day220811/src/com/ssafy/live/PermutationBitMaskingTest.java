package com.ssafy.live;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationBitMaskingTest {

    static int N, R, totalCnt;
    static int[] numbers, input;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        totalCnt = 0;

        input = new int[N];
        numbers = new int[R];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        perm(0, 0);
        System.out.println("총 경우의 수 : " + totalCnt);
    }


    // cnt : 직전까지 뽑은 순에 포함된 수의 개수
    // flag : 선택된 수들의 상태를 비트로 표현하고 있는 비트열 ( 정수 )
    private static void perm(int cnt, int flag){
        if(cnt == R){
            totalCnt += 1;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 0; i < N; i++) {
            if((flag & 1 << i) != 0) continue; // i가 1이었다면
            numbers[cnt] = input[i];
            perm(cnt + 1, (flag | 1 << i));
        }
    }
}
