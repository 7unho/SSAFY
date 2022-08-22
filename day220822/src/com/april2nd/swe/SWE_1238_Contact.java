package com.april2nd.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWE_1238_Contact {
    static int L, start, size = 100 + 1;
    static int[] visit;
    static int[][] graph;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            graph = new int[size][size];
            queue = new LinkedList<>();
            visit = new int[size];

            L = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < L/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from][to] = 1;
            }

            System.out.printf("#%d ", tc);
        }
    }

    static void bfs(int x){
        queue.offer(x);
        visit[x] = 1;
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()){
            int queueSize = queue.size();
            answer = 0;

            for (int i = 0; i < queueSize; i++) {
                int cur = queue.poll();
                for (int j = 1; j < size; j++) {
                    if(graph[cur][j] == 1 && visit[j] == 0){
                        queue.offer(j);
                        visit[j] = 1;
                        answer = Math.max(answer, j);
                    }
                }
            }
            list.add(answer);
        }
        System.out.println(list.get(list.size() - 2));
    }
}
