package com.april2nd.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_3289_서로소집합 {
    static int N, M;
    static StringBuilder answer;
    static int[] parents;

    static void make(){
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    static int find(int[] p, int a){
        if(parents[a] == a) return a;
        return parents[a] = find(p, parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = find(parents, a);
        int bRoot = find(parents, b);

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            answer = new StringBuilder();

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parents = new int[N + 1];
            make();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine()); // 0 a b
                int type = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(type == 0) {
                    union(a, b);
                    continue;
                } else if (type == 1) {
                    if(find(parents, a) == find(parents, b)) answer.append(1);
                    else answer.append(0);
                }
            }

            System.out.printf("#%d %s\n", tc, answer);
        }
    }
}
