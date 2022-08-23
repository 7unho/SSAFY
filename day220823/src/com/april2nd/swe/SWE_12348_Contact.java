package com.april2nd.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWE_12348_Contact {
    static boolean[][] adjMatrix;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

//        for (int tc = 1; tc <= 10; tc++) {}
        int tc = 1;
        String str;
        while( (str = br.readLine()) != null){
            st = new StringTokenizer(str);
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            int from = start;
            int to;

            adjMatrix = new boolean[101][101];
            visited = new boolean[101];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) {
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                adjMatrix[from][to] = true;
            }

            System.out.printf("#%d ", tc++);
            System.out.println(bfs(start));
        }
        br.close();
    }

    static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        int answer = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                answer = Math.max(answer, current);
                for (int j = 1; j <= 100; j++) {
                    if(!visited[j] && adjMatrix[current][j]){
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
            }
        }
        return answer;
    }
}
