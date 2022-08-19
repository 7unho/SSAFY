package com.april2nd.boj;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[100_001];
        int N = sc.nextInt();
        int K = sc.nextInt();

        queue.offer(N);

        while(!queue.isEmpty()){
            int v = queue.poll();
            int[] dx = {-1, 1, v};

            if(v == K) {
                System.out.println(dist[v]);
                break;
            }

            for (int i = 0; i < 3; i++) {
                int nx = v + dx[i];
                if(nx >= 0 && nx < 100001 && dist[nx] == 0){
                    dist[nx] = dist[v] + 1;
                    queue.offer(nx);
                }
            }
        }

    }
}
