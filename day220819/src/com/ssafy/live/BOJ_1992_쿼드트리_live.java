package com.ssafy.live;

import java.util.Scanner;

public class BOJ_1992_쿼드트리_live {
    static char map[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = sc.next().toCharArray();
        }

        Solve(0, 0, N);

        sc.close();
    }

    static void Solve(int x, int y, int n){
        if(isSame(x, y, n)){
            System.out.print(map[x][y]);
            return;
        }

        System.out.print("(");
        int size = n / 2;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Solve(x + i * size, y + j * size, size);
            }
        }

        System.out.print(")");
    }

    static boolean isSame(int x, int y, int n){
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if(map[x][y] != map[i][j]) return false;
            }
        }
        return true;
    }
}