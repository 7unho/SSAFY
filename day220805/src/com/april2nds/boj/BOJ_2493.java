package com.april2nds.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2493 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] answer = new int[N + 1];

        Stack<int[]> stack = new Stack<>();
        for(int i = 1; i <= N; i++) {
            int[] temp = {i, Integer.parseInt(st.nextToken())};
            while(true) {
                if(stack.isEmpty()) {
                    answer[i] = 0;
                    break;
                }
                // 스택 peek의 높이값이 현재 높이보다 높다면
                if(stack.peek()[1] >= temp[1]) {
                    answer[i] = stack.peek()[0];
                    break;
                }
                stack.pop();
            }
            stack.push(temp);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(answer[i] + " ");
        }

    }
}
