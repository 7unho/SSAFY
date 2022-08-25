package com.ssafy.live;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimTest2_PQ {
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

    static class Vertex{
        int no;
        int weight;

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
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
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
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

        PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
        pq.offer(new Vertex(0, minEdge[0]));

        int cnt = 0; // 신장트리에 추가된 정점 수
        while(true) { // V개의 정점을 처리하면 끝
            // step1, 신장트리의 구성에 포함되지 않은 정점 중 최소비용 정점 선택
            Vertex minVertex = pq.poll();

            if(visited[minVertex.no]) continue; // 힙에 계속 추가만 되기때문에, poll하다보면 안쓰는 값들이 나올 수 있다.
                                                // 따라서, 이미 minVertex가 정해진 노드라면 해당 값은 무시해준다.

            // step2, 신장트리에 추가
            visited[minVertex.no] = true;
            answer += minVertex.weight;
            if(++cnt == V) break; // cnt가 V개라면 -> 모든 정점이 신장트리에 추가됐으므로, break

            // step3, 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의 기존 최소비용과 비교해서 갱신
            //        신장트리에 새롭게 추가되는 정점의 모든 인접정점 들여다보며 처리
            for (Node temp = adjList[minVertex.no]; temp != null; temp = temp.next){
                if(!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
                    minEdge[temp.vertex] = temp.weight;
                    pq.offer(new Vertex(temp.vertex, temp.weight));
                }
            }
        }

        System.out.println(answer);
    }
}
