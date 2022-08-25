package com.ssafy.live;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        int[][] adjMatrix = new int[V][V];
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // start -> end 로의 최단 경로
        int start = 0;          // 출발정점
        int end = V - 1;        // 도착정점

        int[] D = new int[V];               // 거리 정보 저장할 배열
        boolean[] visited = new boolean[V]; // 처리한 정점 여부

        Arrays.fill(D, Integer.MAX_VALUE);
        D[start] = 0;

        int min, minVertex;

        for (int i = 0; i < V; i++) {
            // step1, 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택
            // 방문해야하는 나머지 정 중 출발지에서 가장 가까운 정점 찾기
            min = Integer.MAX_VALUE;
            minVertex = -1;
            for (int j = 0; j < V; j++) {
                if(!visited[j] && min > D[j]){
                    min = D[j];
                    minVertex = j;
                }
            }
            // step2, 방문처리
            visited[minVertex] = true;
            if(minVertex == end) break; // 현재 선택된 정점이 타겟 정점이라면 탈출해준다.

            // step3, 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 기존 최적해보다 유리하면 갱신
            for (int j = 0; j < V; j++) {
                if(!visited[j] && adjMatrix[minVertex][j] > 0 && D[j] > D[minVertex] + adjMatrix[minVertex][j]){
                    D[j] = D[minVertex] + adjMatrix[minVertex][j];
                }
            }
        }
        System.out.println(D[end]);
        br.close();
    }
}
