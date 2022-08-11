package com.ssafy.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가_만든_맛있는_음식 {
    // 신맛은 사용한 재료 신맛의 곱
    // 쓴맛은 사용한 재료 쓴맛의 합
    static int N, answer;
    static int[] sours, bitters;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        sours = new int[N];
        bitters = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            sours[i] = Integer.parseInt(st.nextToken());
            bitters[i] = Integer.parseInt(st.nextToken());
        }

        // N이 1일 경우, 재료를 무조건 사용해야 하기에 바로 answer 도출
        if (N == 1) answer = Math.abs(sours[0] - bitters[0]);
        else Solution(0, 0, 0, 1);

        System.out.println(answer);
    }

    public static void Solution(int depth, int cnt, int bitterSum, int sourSum){
        // 기저조건 depth == N 이면 멈추도록
        // 재료는 무조건 1개 이상 사용해야 하기에 -> cnt가 0이 아닐 때만 answer 도출
        if(depth == N){
            if(cnt != 0) answer = Math.min(answer, Math.abs(bitterSum - sourSum));
            return;
        }

        // 조합 재귀
        Solution(depth + 1,  cnt + 1,bitterSum + bitters[depth], sourSum * sours[depth]);
        Solution(depth + 1, cnt, bitterSum, sourSum);
    }
}
