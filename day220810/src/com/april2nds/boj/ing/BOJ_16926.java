package com.april2nds.boj.ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16926 { // 배열_돌리기_1
    static int rows, cols, R;
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());
        arr = new int[rows][cols];
        R = Integer.parseInt(st.nextToken());


        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cols; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int cnt = 0; cnt < R; cnt++) {
            Solution(0, 0, rows - 1, cols - 1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void Solution(int start_row, int start_col, int end_row, int end_col){
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[start_row][start_col]);

        // 아래쪽 방향
        for (int i = start_row + 1; i <= end_row; i++) {
            temp.add(arr[i][start_col]);
            arr[i][start_col] = temp.get(temp.size() - 2);
        }

        // 오른쪽 방향
        for (int j = start_col + 1; j <= end_col; j++) {
            temp.add(arr[end_row][j]);
            arr[end_row][j] = temp.get(temp.size() - 2);
        }

        // 위쪽 방향
        for (int i = end_row - 1; i >= start_row; i--) {
            temp.add(arr[i][end_col]);
            arr[i][end_col] = temp.get(temp.size() - 2);
        }

        // 왼쪽 방향
        for (int j = end_col - 1; j >= start_col; j--) {
            temp.add(arr[start_row][j]);
            arr[start_row][j] = temp.get(temp.size() - 2);
        }

        if((start_row + 1 <= end_row - 1) || (start_col + 1 <= end_col - 1)) Solution(start_row + 1, start_col + 1, end_row - 1, end_col - 1);

    }
}
