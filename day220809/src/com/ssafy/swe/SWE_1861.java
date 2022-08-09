package com.ssafy.swe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_1861 {
    static int[][] graph;
    static int N, maxValue, minNum;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("day220809/res/input_1861.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());


        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];
            maxValue = Integer.MIN_VALUE;
            minNum = Integer.MAX_VALUE;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dfs(i, j, 1, graph[i][j]);
                }
            }

            System.out.printf("#%d %d %d\n", tc, minNum, maxValue);

        }
    }

    public static void dfs(int x, int y, int cnt, int start){
        if (cnt > maxValue){
            maxValue = cnt;
            minNum = start;
        }

        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N && graph[x][y] + 1 == graph[nx][ny]) dfs(nx, ny, cnt + 1, start);
        }
    }

}
