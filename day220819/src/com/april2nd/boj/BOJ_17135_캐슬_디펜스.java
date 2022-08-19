package com.april2nd.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬_디펜스 {
    static int N, M, D, answer;
    static int[][] map;
    static int[] archor;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        answer = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        archor = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(archor, 0, 0, 3);

    }

    static void combi(int[] archor, int depth, int start, int r){
        if(r == 0){
            System.out.println(Arrays.toString(archor));
            // 조합된 궁수 배열을 공격하는 메서들 전송...
            return;
        }

        for (int i = start; i < N; i++) {
            archor[i] = 2;
            combi(archor, depth + 1, i + 1, r - 1);
            archor[i] = 0;
        }
    }

    static void attack(int[] archor){
        for (int i = 0; i < 3; i++) {
            if(archor[i] == 0) continue;
            for (int x = N - 1; x <= 0; x--) {
                for (int y = 0; y < M; y++) {
                    if(distCheck(x, y, archor[i])) {
                        map[x][y] = 0;
                        answer += 1;
                    }
                }
            }
        }
    }

    static boolean distCheck(int x, int y, int archorY){
        return ((N - x) + Math.abs(y - archorY)) <= D ? true : false;
    }
}
