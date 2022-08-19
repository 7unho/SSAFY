package com.april2nd.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_3234_준환이의_양팔저울 {
    static int answer;
    static int[] weights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            answer = 0;

            boolean[] isSelected = new boolean[N];
            weights = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
            }

            Solution(weights, isSelected, 0, 0, 0, N);
            System.out.printf("#%d %d\n", tc, answer);
        }
    }

    static void Solution(int[] weights, boolean[] isSelected, int depth, int lSum, int rSum, int n) {
        if(lSum < rSum) return;

        if (depth == n) {
            answer += 1;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            Solution(weights, isSelected, depth + 1, lSum + weights[i], rSum, n);
            Solution(weights, isSelected, depth + 1, lSum, rSum + weights[i], n);
            isSelected[i] = false;
        }
    }
}

