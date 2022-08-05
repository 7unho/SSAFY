package com.april2nds.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer;
        int[][] graph;
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            graph = new int[N][N];
            int temp = 0;
            answer = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < (N - M) + 1; i++) {
                for (int j = 0; j < (N - M) + 1; j++) {
                    temp = 0;

                    for (int nx = 0; nx < M; nx++) {
                        for (int ny = 0; ny < M; ny++) {
                            temp += graph[i + nx][j + ny];
                        }
                    }
                    answer = Math.max(answer, temp);
                }
            }

            System.out.printf("#%d %d\n", tc, answer);
        }
    }
}
