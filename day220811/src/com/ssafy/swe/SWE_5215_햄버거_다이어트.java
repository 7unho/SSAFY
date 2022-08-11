package com.ssafy.swe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWE_5215_햄버거_다이어트 {
    static int N, L, answer; // N : 재료의 수, L : 제한 칼로리

    static int[] kcalList, valList;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("day220811/res/SWE_5215_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            answer = 0;

            kcalList = new int[N];
            valList = new int[N];

            for (int i = 0; i < N; i++) {
                int[] temp = new int[2];
                st = new StringTokenizer(br.readLine());

                valList[i] = Integer.parseInt(st.nextToken());
                kcalList[i] = Integer.parseInt(st.nextToken());
            }

            Permutation(0, 0, 0);
            System.out.printf("#%d %d", tc, answer);
        }
    }

    static void Permutation(int depth, int kcal, int value){
        // 현재 칼로리의 합이 제한 칼로리보다 크다면 리턴
        if(kcal > L) return;

        // 현재 재료의 개수가 N과 같아지면 answer 최신화
        if(depth == N){
            answer = Math.max(answer, value);
            return;
        }

        // 현재 재료를 포함하는 경우
        Permutation(depth + 1, kcal + kcalList[depth], value + valList[depth]);

        // 현재 재료를 포함하지 않는 경우
        Permutation(depth + 1, kcal, value);
    }
}
