package com.april2nds.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_2805 {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp;

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            int N = Integer.parseInt(br.readLine());
            int answer = 0;

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                temp = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = temp.charAt(j) - 48;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i <= N / 2){
                        if(j >= (N / 2 - i) && j <= (N / 2 + i)){
                            answer += map[i][j];
                            System.out.println(map[i][j]);
                        }
                    }
                    else{
                        if(j >= (N / 2 - (N - 1 - i)) && j <= (N / 2 + (N - 1 - i))){
                            answer += map[i][j];
                            System.out.println(map[i][j]);
                        }
                    }

                }
            }

            System.out.printf("#%d %d", tc, answer);
        }
    }
}