package com.ssafy.live;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485_젤다_Live {
    static int N;
    static int[][] map;
    static int[][] distance;
    static int answer;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int no = 0;
        while(true){
            N = Integer.parseInt(br.readLine());

            if(N == 0) break; // 종료 조건

            map = new int[N][N];
            distance = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(br.readLine());
                }
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }

            // 알고리즘 구현
//            solve();

            System.out.println("Problem " + ++no + ":" + solve());
        }
    }

    private static int solve(){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0, 0, map[0][0]));
        distance[0][0] = map[0][0];

        while(!queue.isEmpty()){ // 큐에 Node가 존재한다면
            Node node = queue.poll(); // 최소거리(비용)의 Node;

            // 방문했는지, 처리는 했는지
            if(distance[node.row][node.col] == Integer.MAX_VALUE) continue;

            for (int i = 0; i < 4; i++) {
                int nx = node.col + dx[i];
                int ny = node.row + dy[i];

                if(ny < 0 || ny >= N || nx < 0 || ny >= N) continue;
                if(distance[ny][nx] < distance[node.row][node.col] + map[ny][nx]){ // 최소거리 (비용) 발견 시
                    distance[ny][nx] = distance[node.row][node.col] + map[ny][nx];
                    queue.offer(new Node(ny, nx, map[ny][nx]));
                }
            }
        }
        return distance[N - 1][N - 1];
    }

    static class Node implements Comparable<Node>{ // 배열일때는 comparable, 리스트는 comparator
        int row;
        int col;
        int cost;

        public Node(int row, int col, int cost) {
            super();
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    ", cost=" + cost +
                    '}';
        }
    }
}
