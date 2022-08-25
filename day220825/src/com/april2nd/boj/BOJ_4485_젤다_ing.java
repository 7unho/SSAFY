package com.april2nd.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최소로 잃는 경로 찾기
public class BOJ_4485_젤다_ing {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = 1;
        while(true){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }



            if(N == 0) break;


        }
    }
}
