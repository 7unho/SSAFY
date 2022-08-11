package com.april2nds.boj.end;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int x, y, width, height;

        int[][] graph = new int[101][101];

        int N = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= N; tc++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());

            for (int i = x; i < x + width; i++) {
                for (int j = y; j < y + height; j++) {
                    graph[i][j] = tc;
                }
            }
        }

        for (int value = 1; value <= N; value++) {
            int answer = 0;
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    if(graph[i][j] == value) answer += 1;
                }
            }

            System.out.println(answer);
        }
    }
}
