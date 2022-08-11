package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2563 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int[][] arr = new int[100][100];
        int result = 0;
        int x, y = 0;

        for (int i = 0; i < input; i++) {
            x = sc.nextInt();
            y = sc.nextInt();

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if(arr[j][k] == 0){
                        arr[j][k] = 1;
                        result += 1;
                    }
                }
            }
        }
        System.out.println(result);
        sc.close();
    }
}
