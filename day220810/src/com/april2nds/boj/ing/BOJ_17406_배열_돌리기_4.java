package com.april2nds.boj.ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406_배열_돌리기_4 {
    static int[][] graph;
    static int[][] cpyGraph;
    static int rows, cols, K;
    static int R, C, S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= cols; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // k번 만큼 회전연산 쿼리 입력받고, 연산 수행
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());


    }
}
