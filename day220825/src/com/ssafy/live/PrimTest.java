package com.ssafy.live;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrimTest {
    private static int answer;

    static class Node{
        int vertex, weight; // 정점과 가중치
        Node next;          // 연결리스트 연결을 위한 포인터

        public Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Node[] adjList = new Node[V]; // 각 정점별 인접리스트

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 무향 그래프처리
            adjList[from] = new Node(to, weight, adjList[from]);
            adjList[to] = new Node(to, weight, adjList[to]);
        }

        // 프림 알고리즘에 필요한 자료구조
        int[] minEdge = new int[V];         // 각 정점이 신장트리에 포함된 정점과의 간선 비용 중 최소 비용
        boolean[] visited = new boolean[V]; // 신장트리에 포함 여부

        Arrays.fill(minEdge, Integer.MAX_VALUE); // 최솟값 비교를 위해 max로 초기화

        // 1. 임의의 시작점 처리 -> 편의상 0번 정점을 신장트리 구성의 시작점
        minEdge[0] = 0; // 시작점의 비용을 0으로 초기화 : 본인과의 연결비용은 0이므로 !
        int answer = 0; // 최소신장트리 비용 누적용 변수

        for (int c = 0; c < V; c++) { // V개의 정점을 처리하면 끝
            // step1, 신장트리의 구성에 포함되지 않은 정점 중 최소비용 정점 선택
            int min = Integer.MAX_VALUE;
            int minVertex = -1;
            for (int i = 0; i < V; i++) {
                if(!visited[i] && min > minEdge[i]){ // 방문하지 않은 노드 : 신장트리에 포함되지 않은 노드이면서, 연결비용이 min보다 작다면
                    min = minEdge[i];
                    minVertex = i;
                }
            }

            // step2, 신장트리에 추가
            visited[minVertex] = true;
            answer += min;

            // step3, 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의 기존 최소비용과 비교해서 갱신
            //        신장트리에 새롭게 추가되는 정점의 모든 인접정점 들여다보며 처리
            for (Node temp = adjList[minVertex]; temp != null; temp = temp.next){
                if(!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
                    minEdge[temp.vertex] = temp.weight;
                }
            }
        }

        System.out.println(answer);
    }
}
