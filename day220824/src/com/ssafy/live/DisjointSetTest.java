package com.ssafy.live;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DisjointSetTest {
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static Edge[] edgeList;
    static int[] parents;
    static int V, E;

    static void make(){
        for (int i = 0; i < V; i++) {
            parents[i] = i;
        }
    }
    static int find(int a){
        if(parents[a] == a) return a;
        return(find(parents[a]));
    }
    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false; // 같으면 이미 결합되어 있다 : 대표자가 같다
                                         // 사이클이 발생하는 조건
        parents[bRoot] = aRoot;
        return true; // 사이클이 발생하지 않는다
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V];
        edgeList = new Edge[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(from, to, weight);
        }

        make();

        Arrays.sort(edgeList);
        int result = 0;
        int count = 0;
        for (Edge edge: edgeList) {
            if(union(edge.start, edge.end)){ // union이 true => 사이클이 발생하지 않을 때,
                result += edge.weight;
                System.out.printf("시작 정점 : %d, 끝 정점 : %d\n", edge.start, edge.end);
                if(++count == V - 1) break;
            }
        }
        System.out.println(result);
    }
}

//5 10
//0 1 5
//0 2 10
//0 3 8
//0 4 7
//1 2 5
//1 3 3
//1 4 6
//2 3 1
//2 4 3
//3 4 1 => 10