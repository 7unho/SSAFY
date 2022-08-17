package com.april2nd.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15683_감시_ing {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] graph;
    static int answer;
    static List<int[]> cctvList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        cctvList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] >= 1 && graph[i][j] <= 5) cctvList.add(new int[]{i, j, graph[i][j]});
            }
        }

    }

    static void Solution() {
        for (int i = 0; i < cctvList.size(); i++) {
            int x = cctvList.get(i)[0];
            int y = cctvList.get(i)[1];
            int type = cctvList.get(i)[2];

            switch (type){
                case 1:
                    for (int direction = 0; direction < 4; direction++) {
                        type1(cctvList.get(i), direction);
                    }
                    break;
            }

        }
    }

    static int cntZero() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) cnt += 1;
            }
        }
        return cnt;
    }

    static void type1(int[] cctv, int direction) {
        int[][] cpyGraph = new int[N][M];
        int x = cctv[0];
        int y = cctv[1];

        while (true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;
            if (graph[nx][ny] == 6) {
                cpyGraph[nx][ny] = 6;
                break;
            }

            cpyGraph[nx][ny] = -1;
            x = nx;
            y = ny;
        }
    }


    static void type2(int x, int y) {

    }

    static void type3(int x, int y) {

    }

    static void type4(int x, int y) {

    }

    static void type5(int x, int y) {

    }
}
