package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder answer = new StringBuilder();
        answer.append("<");

        int N, K;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while(true){
            if (queue.size() == 1) {
                answer.append(queue.poll()).append(">");
                break;
            }
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            answer.append(queue.poll()).append(", ");
        }


        System.out.println(answer);
    }
}
