package com.ssafy.live;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TopologySortTest {
    static class Node{
        int vertex;
        Node next;

        public Node(int vertex, Node next) {
            this.vertex = vertex;
            this.next = next;
        }
    }

    static int V, E;
    static Node[] adjList;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new Node[V + 1];
        inDegree = new int[V + 1]; // 각 정점별 진입차수

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            // 유향 처리
            adjList[from] = new Node(to, adjList[from]);
            inDegree[to]++;
        }

        ArrayList<Integer> list = topologySort();
        if(list.size() == V){
            System.out.println(Arrays.toString(list.toArray()));
        } else{
            System.out.println("사이클 발생");
        }

    }

    private static ArrayList<Integer> topologySort(){
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < V; i++) {
            if(inDegree[i] == 0) queue.offer(i); // 진입 차수가 0인 것들을 큐에 삽입
        }

        // BFS
        while(!queue.isEmpty()){
            int current = queue.poll();
            list.add(current);

            for (Node temp = adjList[current]; temp != null; temp = temp.next) {
                if(--inDegree[temp.vertex] == 0) queue.offer(temp.vertex); // 해당 진입차수를 1줄인게 0이면 -> 더이상 선행작업이 없다면 : queue에 정점 삽입
            }
        }

        return list;
    }
}
