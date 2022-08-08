package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_12891 {
    static int[] targetCnt = new int[4];
    static int[] curCnt;
    static int sum;
    static int S, T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        String input = br.readLine();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            targetCnt[i] = Integer.parseInt(st.nextToken());
        }

        Solution(input);
        System.out.println(sum);

    }

    public static void Solution(String input){
        for (int i = 0; i < (S - T + 1); i++) {
            String temp = input.substring(i, i + T);
            curCnt = new int[4];
            boolean flag = true;

            for (int j = 0; j < temp.length(); j++) {
                switch (temp.charAt(j)){
                    case 'A':
                        curCnt[0]++;
                        break;
                    case 'C':
                        curCnt[1]++;
                        break;
                    case 'G':
                        curCnt[2]++;
                        break;
                    case 'T':
                        curCnt[3]++;
                        break;
                }
            }

            for (int j = 0; j < 4; j++) {
                if(targetCnt[j] > curCnt[j]) flag = false;
            }

            if(flag) sum++;
        }
    }
}
