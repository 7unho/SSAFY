package com.ssafy.swe;

import java.util.Scanner;

public class Solution_1954_달팽이_숫자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        int num, N;

        for (int tc = 1; tc <= TC; tc++) {
            num = 0;
            N = sc.nextInt();
            int[][] arr = new int[N][N];

            int cnt = N;
            int k = 1;
            int right = -1;
            int bottom = 0;
            int top = 1;

            for (int i = N; i > 0; i--) {

                for (int j = 0; j < cnt; j++) {
                    right += top;
                    arr[bottom][right] = k;
                    k++;
                }

                cnt--;

                for (int j = 0; j < cnt; j++) {
                    bottom += top;
                    arr[bottom][right] = k;
                    k++;
                }

                top = top * (-1);
            }

            // 출력
            System.out.printf("#%d\n", tc);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.printf("%d ", arr[i][j]);
                }
                System.out.println();
            }

        }
    }
}
