package com.ssafy;

import java.util.Scanner;

public class SubSetTest {
    static int N, totalCnt;
    static int[] input;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        totalCnt = 0;
        input = new int[N];
        isSelected = new boolean[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        subSet(0, 0);
        System.out.println("총 경우의 수 : " + totalCnt);

    }

    private static void subSet(int index, int sum){
        if(index == N){
            totalCnt++;
            if(sum == 5){
                for (int i = 0; i < N; i++) {
                    System.out.print(isSelected[i] ? input[i] : "X");
                    System.out.print("\t");
                }
                System.out.println();
            }
            return;
        }
        // 원소 선택
        isSelected[index] = true;
        subSet(index + 1, sum + input[index]);
        // 원소 미선택
        isSelected[index] = false;
        subSet(index + 1, sum);
    }

}
