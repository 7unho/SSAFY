package com.ssafy.live;

import java.util.Scanner;

// N개의 자연수를 입력받고 목표합을 갖는 부분집합을 출력하기
public class SubSetSumTest {
    static int N, totalCnt, S, CALLCNT;
    static int[] input;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt(); // 목표 합
        totalCnt = 0;
        input = new int[N];
        isSelected = new boolean[N];
        CALLCNT = 0;

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        subSet(0, 0);
        System.out.println("총 경우의 수 : " + totalCnt);
        System.out.println("총 호출 횟수 : " + CALLCNT);

    }

    private static void subSet(int index, int sum) {
        CALLCNT += 1;
        if (sum == S) {
            totalCnt++;

            for (int i = 0; i < N; i++) {
                if (isSelected[i]) System.out.print(input[i] + "\t");
            }
            System.out.println();
            return;
        }

        if(sum > S || index == N) return;

        // 원소 선택
        isSelected[index] = true;
        subSet(index + 1, sum + input[index]);
        // 원소 미선택
        isSelected[index] = false;
        subSet(index + 1, sum);
    }

}
