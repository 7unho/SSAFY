package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3040_백설공주와_일곱난쟁이 { // 합이 100이 되는 경우의 수 찾기
    static final int TARGET = 100;
    static int sum;
    static int[] array = new int[9];
    static String answer = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            array[i] = sc.nextInt();
        }
        Solution(0, 0, "", 0);
        System.out.println(answer.toString());
    }

    public static void Solution(int depth, int cnt, String str, int sum){
        if(depth == 9){
            if(cnt == 7 && sum == TARGET) answer = str;
            return;
        }

        Solution(depth + 1, cnt + 1, str + array[depth] + "\n", sum + array[depth]);
        Solution(depth + 1, cnt, str, sum);
    }
}
