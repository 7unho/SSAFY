package com.april2nds.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, I, J, answer;
        String temp;
        int[] arr;

        temp = br.readLine();
        st = new StringTokenizer(temp);
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        
        temp = br.readLine();
        st = new StringTokenizer(temp);

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int tc = 0; tc < M; tc++) {
            temp = br.readLine();
            st = new StringTokenizer(temp);
            answer = 0;

            I = Integer.parseInt(st.nextToken());
            J = Integer.parseInt(st.nextToken());

            for (int i = I; i < ((J - I) / 2) + I ; i++) {
                answer += arr[i] + arr[(I + J) - i];
            }

            answer += arr[(J - I) / 2 + I];
            System.out.println(answer);
        }
        
    }
}
