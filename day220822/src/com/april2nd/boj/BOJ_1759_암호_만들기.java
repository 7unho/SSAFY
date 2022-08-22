package com.april2nd.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호_만들기 {
    static int L, C;
    static char[] array, answer;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        answer = new char[C];
        array = new char[C];
        isSelected = new boolean[C];

        Solution(0, 0);
    }

    static void Solution(int depth, int cnt){
        if(depth == C){
            return;
        }

        if(cnt == L){
            System.out.println(Arrays.toString(answer));
            return;
        }

        answer[cnt] = array[depth];
        Solution(depth + 1, cnt + 1);
        Solution(depth + 1, cnt);
    }
}
