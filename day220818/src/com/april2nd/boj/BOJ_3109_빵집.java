package com.april2nd.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
    static int R, C, answer;
    static char[][] graph;
    static int[][] visited;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        visited = new int[R][C];
        answer = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i] = st.nextToken().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            if(dfs(i, 0)) answer += 1;
        }

        System.out.println(answer);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean dfs(int x, int y) {
        if (y == C - 1) {
            return true;
        }

        int nx, ny;

        for (int i = 0; i < 3; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) return false;
            if (graph[nx][ny] == 'x') return false;
            if (visited[nx][ny] == 0){
                visited[nx][ny] = 1;
                dfs(nx, ny);
            }
        }
        return true;
    }
}
