package com.ssafy.live;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST2_Prim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim()); // 정점의 수
        int[][] input = new int[N][N]; // 가중치를 저장하는 배열
        boolean[] visited = new boolean[N]; // 정점 방문 체크
        int[] minEdge = new int[N]; // 최소 간선 정보 저장

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.fill(minEdge, Integer.MAX_VALUE);

        // 선택된 최소 정점, 최솟값 기준 최소 가중치 저장, 최소신장트리의 가중치 누적합
        int minVertex, min, result = 0;
        minEdge[0] = 0; // 0을 임의의 시작점으로 잡음

        for (int i = 0; i < N; i++) { // 모든 정점 수 만큼 반복
            min = Integer.MAX_VALUE;  // min 초기화
            minVertex = 0;

            for (int j = 0; j < N; j++) {
                if(!visited[j] && min > minEdge[j]){ // 최소 가중치값 찾기
                    min = minEdge[j];
                    minVertex = j;
                }
            }

            result += min; // 찾은 최소 가중치를 저장
            visited[minVertex] = true; // 최소 가중치를 갖는 정점에 방문 체크

            for (int j = 0; j < N; j++) {
                // 이전 보다 작은 최솟값을 찾았다면
                if(!visited[j] && input[minVertex][j] != 0 && minEdge[j] > input[minVertex][j]){
                    minEdge[j] = input[minVertex][j];
                    System.out.println(i + " == > " + minEdge[j]);
                }
            }
        }

        System.out.println(result);

        br.close();
    }
}


//        5
//        0 5 10 8 7
//        5 0 5 3 6
//        10 5 0 1 3
//        8 3 1 0 1
//        7 6 3 1 0
//
//        output==>10
//
//        7
//        0 32 31 0 0 60 51
//        32 0 21 0 0 0 0
//        31 21 0 0 46 0 25
//        0 0 0 0 34 18 0
//        0 0 46 34 0 40 51
//        60 0 0 18 40 0 0
//        51 0 25 0 51 0 0
//
//        output==>175