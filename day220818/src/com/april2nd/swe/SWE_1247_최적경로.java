package com.april2nd.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_1247_최적경로 {
    static int answer, N;
    static int homeX, homeY, corpX, corpY;
    static boolean[] isSelected;
    static int[][] points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            answer = 0;
            N = Integer.parseInt(br.readLine());
            isSelected = new boolean[N];
            points = new int[N][2];

            st = new StringTokenizer(br.readLine());

            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());
            corpX = Integer.parseInt(st.nextToken());
            corpY = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                points[i] = new int[]{x, y};
            }

            Solution(0);
            System.out.printf("#%d %d\n", tc, answer);

        }
    }

    static void Solution(int depth){
        if ( depth == N ) {
            // 여기서 좌표 배열 순회하면서 거릿값 누적시키기. answer = Math.min(answer, temp);
            int temp = 0;
            for (int i = 0; i < N; i++) {
//                int x = points[isSelected[i]]
            }
        }
        for (int i = 0; i < N; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            Solution(depth + 1);
        }
    }
}
