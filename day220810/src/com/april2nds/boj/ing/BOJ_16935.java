package com.april2nds.boj.ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16935 {
    public static int rows, cols, R;
    public static int[][] graph;
    public static int[][] cpGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());
        graph = new int[rows][cols];
        cpGraph = new int[rows][cols];
        R = Integer.parseInt(st.nextToken());
        int query;

        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cols; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            query = Integer.parseInt(st.nextToken());

            switch (query){
                case 1:
                    Solution1();
                    break;
                case 2:
                    Solution2();
                    break;
                case 3:
                    Solution3();
                    break;
                case 4:
                    Solution4();
                    break;
                case 5:
                    Solution5();
                    break;
                case 6:
                    Solution6();
                    break;
            }
        }


        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void Solution1(){ // 상하 반전
        int temp = 0;
        for (int i = 0; i < graph.length / 2; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                temp = graph[i][j];
                graph[i][j] = graph[(rows - 1)-i][j];
                graph[(rows - 1)-i][j] = temp;
            }
        }
    }
    public static void Solution2(){ // 좌우 반전
        int temp = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length / 2; j++) {
                temp = graph[i][j];
                graph[i][j] = graph[i][(cols - 1) - j];
                graph[i][(cols - 1)- j] = temp;
            }
        }
    }
    public static void Solution3(){ // 오른쪽 90도
        cpGraph = new int[graph[0].length][graph.length];

        int temp = graph.length - 1;
        for (int i = 0; i < cpGraph[0].length; i++) {
            for (int j = 0; j < cpGraph.length; j++) {
                cpGraph[j][temp] = graph[i][j];
            }
            temp -= 1;
        }

        graph = cpGraph;
    }
    public static void Solution4(){ // 왼쪽 90도
        cpGraph = new int[graph[0].length][graph.length];

        for (int i = 0; i < cpGraph[0].length; i++) {
            for (int j = 0; j < cpGraph.length; j++) {
                cpGraph[cpGraph.length - j - 1][i] = graph[i][j];
            }
        }

        graph = cpGraph;
    }
    public static void Solution5(){
        int rows = graph.length;
        int cols = graph[0].length;
        cpGraph = new int[rows][cols];

        int rows_mid = graph.length / 2;
        int cols_mid = graph[0].length / 2;

        for (int i = 0; i < rows_mid; i++) {
            for (int j = 0; j < cols_mid; j++) {
                cpGraph[i][j + cols_mid] = graph[i][j];
            }
        }

        for (int i = 0; i < rows_mid; i++) {
            for (int j = cols_mid; j < cols; j++) {
                cpGraph[rows_mid + i][j] = graph[i][j];
            }
        }

        for (int i = rows_mid; i < rows; i++) {
            int index = 0;
            for (int j = cols_mid; j < cols; j++) {
                cpGraph[i][index] = graph[i][j];
                index += 1;
            }
        }

        int index = 0;
        for (int i = rows_mid; i < rows; i++) {
            for (int j = 0; j < cols_mid; j++) {
                cpGraph[index][j] = graph[i][j];
            }
            index += 1;
        }

        graph = cpGraph;
    }
    public static void Solution6(){
        int rows = graph.length;
        int cols = graph[0].length;
        cpGraph = new int[rows][cols];

        int rows_mid = graph.length / 2;
        int cols_mid = graph[0].length / 2;

        for (int i = 0; i < rows_mid; i++) {
            for (int j = 0; j < cols_mid; j++) {
                cpGraph[rows_mid + i][j] = graph[i][j];
            }
        }

        for (int i = rows_mid; i < rows; i++) {
            for (int j = 0; j < cols_mid; j++) {
                cpGraph[i][j + cols_mid] = graph[i][j];
            }
        }

        int index = 0;
        for (int i = rows_mid; i < rows; i++) {
            for (int j = cols_mid; j < cols; j++) {
                cpGraph[index][j] = graph[i][j];
            }
            index += 1;
        }

        for (int i = 0; i < rows_mid; i++) {
            index = 0;
            for (int j = cols_mid; j < cols; j++) {
                cpGraph[i][index] = graph[i][j];
                index += 1;
            }
        }

        graph = cpGraph;
    }
}
