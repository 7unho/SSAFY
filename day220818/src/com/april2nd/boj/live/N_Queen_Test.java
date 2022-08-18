package com.april2nd.boj.live;

import java.util.Scanner;

public class N_Queen_Test {
    static int N, cols[], answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        cols = new int[N + 1];
        answer = 0;

        setQueen(1);
        System.out.println(answer);
    }

    public static void setQueen(int rowNo){ // 플랫한 시야 : 하나의 퀸만 가능한 모든 곳에 놓아보기
        // 기저 파트
        if(rowNo > N){ // 퀸을 다 놓았다면
            answer += 1;
            return;
        }

        // 유도 파트
        for (int i = 1; i <= N; i++) {
            cols[rowNo] = i;
            if(!isAvailable(rowNo)) setQueen(rowNo + 1);
        }
    }

    public static boolean isAvailable(int rowNo){
        for (int i = 1; i < rowNo; i++) { // 처음 행부터 직전 행까지 비교
            // 열값이 같거나 ( 일직선상에 위치하거나 ), 행차이와 열차이가 같다면 ( 대각선에 위치하면 )
            if(cols[i] == cols[rowNo] || rowNo - i == Math.abs(cols[rowNo] - cols[i])) return false;
        }
        return true;
    }
}
