package com.ssafy.swe;

import java.util.Arrays;
import java.util.Scanner;

public class SWE_1208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] graph = new int[100];
        int answer = 0;

        for (int tc = 1; tc <= 10; tc++) {
            int query = sc.nextInt();

            for (int i = 0; i < graph.length; i++) {
                graph[i] = sc.nextInt();
            }
            Arrays.sort(graph);

            for (int i = 0; i < query; i++) {
                graph[0] += 1;
                graph[(graph.length - 1)] -= 1;

                if (Math.abs(graph[0] - graph[(graph.length - 1)]) <= 1) break;
                Arrays.sort(graph);
            }

            answer = graph[(graph.length - 1)] - graph[0];
            System.out.println(graph);
            System.out.printf("#%d %d\n", tc, answer);
        }
    }
}
