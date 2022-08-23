package com.april2nd.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//빈 곳은 '.', 물 '*', 돌 'X', 비버의 굴 'D', 고슴도치 'S'
public class BOJ_3055_탈출 {
    static int R, C, dX, dY;
    static char[][] graph;
    static int[][] answer;
    static Queue<int[]> wQueue; // 물
    static Queue<int[]> sQueue; // 고슴도치
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        answer = new int[R][C];

        wQueue = new LinkedList<>();
        sQueue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            graph[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if(graph[i][j] == '*') wQueue.offer(new int[]{i, j});
                else if(graph[i][j] == 'S') sQueue.offer(new int[]{i, j});
                else if(graph[i][j] == 'D'){
                    dX = i;
                    dY = j;
                }
            }
        }

        Solution();
        if(answer[dX][dY] == 0) System.out.println("KAKTUS");
        else System.out.println(answer[dX][dY]);
    }

    public static void Solution(){
        while(!sQueue.isEmpty()){
            int[] wPoints = wQueue.poll();
            int[] sPoints = sQueue.poll();

            for (int i = 0; i < 4; i++) {
                int wnx = wPoints[0] + dx[i];
                int wny = wPoints[1] + dy[i];

                int snx = sPoints[0] + dx[i];
                int sny = sPoints[1] + dy[i];

                if(wnx >= 0 && wnx < R && wny >= 0 && wny < C){
                    if(graph[wnx][wny] != 'D' || graph[wnx][wny] != 'X' || answer[wnx][wny] != -1){
                        answer[wnx][wny] = -1;
                        wQueue.offer(new int[]{wnx, wny});
                    }
                }

                if(snx >= 0 && snx < R && sny >= 0 && sny < C){
                    if(answer[snx][sny] != -1 || graph[snx][sny] != 'X' || answer[snx][sny] == 0){
                        answer[snx][sny] = answer[sPoints[0]][sPoints[1]] + 1;
                        sQueue.offer(new int[]{snx, sny});
                    }
                }
            }
        }
    }
}
