package com.april2nd.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7576_토마토 {
    static int N, M;
    static int[][] graph;
//    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();

        graph = new int[N][M];
//        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) queue.offer(new int[]{i, j});
            }
        }

        bfs();
        System.out.println(Solution());

    }

    static void bfs(){
        while(!queue.isEmpty()){
            int[] points = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = points[0] + dx[i];
                int ny = points[1] + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(graph[nx][ny] == 0){
//                        visited[nx][ny] = true;
                        graph[nx][ny] = graph[points[0]][points[1]] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static int Solution(){
        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == 0) return -1;
                answer = Math.max(answer, graph[i][j]);
            }
        }

        return answer - 1;
    }
}
