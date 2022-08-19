package com.april2nd.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
    static int R, C;
    static char[][] graph;
    static int[][] visited;
    static char[] answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visited = new int[R][C];

        for (int i = 0; i < R; i++) {
            graph[i] = br.readLine().toCharArray();
        }
    }

    static boolean Solution(int x, int y){
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny] == 1) return false;
            visited[nx][ny] = 1;

        }
        return true;
    }
}
