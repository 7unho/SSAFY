package com.april2nds.swe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWE_4012_요리사 { // 두 음식 간 맛의 차이가 최소가 되는 해답을 구하라
    // 음식당 N / 2의 재료를 사용하여, 값 비교
    static int N, answer;
    static int[][] graph;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("day220812/res/SWE_4012_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];
            answer = Integer.MAX_VALUE;
            isSelected = new boolean[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Subset(0, 0);
            System.out.printf("#%s %d\n", tc, answer);
        }
    }

    public static void Subset(int depth, int cnt){
        if(depth == N){
            if(cnt == N / 2){
                List<Integer> food1 = new ArrayList<>();
                List<Integer> food2 = new ArrayList<>();
                for (int i = 0; i < isSelected.length; i++) {
                    if(!isSelected[i]) food1.add(i);
                    else food2.add(i);
                }
                int f1 = foodValue(food1);
                int f2 = foodValue(food2);

                answer = Math.min(answer, Math.abs(f1 - f2));
            }
            return;
        }

        isSelected[depth] = true;
        Subset(depth + 1, cnt + 1);
        isSelected[depth] = false;
        Subset(depth + 1, cnt);
    }

    public static int foodValue(List<Integer> food){
        // food에는 조합된 재료의 인덱스가 들어가 있다.
        // ex) 4c2 -> [0, 1], [0, 2], [0, 3], ...
        int sum = 0;
        for (int i = 0; i < food.size(); i++) {
            for (int j = 0; j < food.size(); j++) {
                if (i == j) continue;
                sum += graph[food.get(i)][food.get(j)];
            }
        }
        return sum;
    }
}
