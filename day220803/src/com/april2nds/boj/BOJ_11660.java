package com.april2nds.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start_i, start_j, end_i, end_j;
        int[][] map;
        String temp;

        int N, M, answer;

        temp = br.readLine();
        st = new StringTokenizer(temp);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            temp = br.readLine();
            st = new StringTokenizer(temp);
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int tc = 0; tc < M; tc++) {
            st = new StringTokenizer(br.readLine());
            answer = 0;

            start_i = Integer.parseInt(st.nextToken());
            end_i = Integer.parseInt(st.nextToken());
            start_j = Integer.parseInt(st.nextToken());
            end_j = Integer.parseInt(st.nextToken());

            for (int i = 0; i < (end_i - start_i) + 1; i++) {
                for (int j = start_j; j < (end_j - start_j) / 2 + start_j ; j++) {
                    answer += map[i][j] + map[i][start_i + start_j - j];
                }
                answer += map[i][(end_j - start_j) / 2 + start_i];

                System.out.println(answer);
            }
        }
    }
}
