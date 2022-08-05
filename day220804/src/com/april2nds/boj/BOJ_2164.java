package com.april2nds.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2164 {
    static int N;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queue = new LinkedList<>();
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++)
            queue.add(i);

        for (int i = 0; i < N - 1; i++) {
            int temp = 0;

            queue.poll();
            temp = queue.poll();
            queue.offer(temp);
        }

        System.out.println(queue.poll());

        br.close();
    }
}
