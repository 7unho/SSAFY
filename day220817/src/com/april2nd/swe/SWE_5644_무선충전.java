package com.april2nd.swe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_5644_무선충전 {
    static int M, A, answer, ax, ay, bx, by;
    // x, 상, 우, 하, 좌
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};
    static int[][] graph;
    static int[] userA, userB;
    static AP[] APArray;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("day220817/res/SWE_5644_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            graph = new int[11][11];
            answer = 0;

            userA = new int[M + 1];
            userB = new int[M + 1];
            APArray = new AP[A];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                userA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                userB[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                APArray[i] = new AP((i + 1), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            ax = ay = 1;
            bx = by = 10;
            for (int i = 0; i <= M; i++) {
                int max = 0;
                ax += dx[userA[i]];
                ay += dy[userA[i]];

                bx += dx[userB[i]];
                by += dy[userB[i]];

                for (int j = 0; j < A; j++) {
                    AP aVal = new AP();
                    if(isAPRange(APArray[j], ax, ay)) aVal = APArray[j];
                    for (int k = 0; k < A; k++) {
                        AP bVal = new AP();
                        if(isAPRange(APArray[k], bx, by)) bVal = APArray[k];

                        if(aVal.id != bVal.id) max = Math.max(max, aVal.p + bVal.p);
                        else max = Math.max(max, aVal.p);
                    }
                }

                answer += max;
            }
            System.out.printf("#%s %d\n", tc, answer);
        }
    }

    static boolean isAPRange(AP ap, int x, int y){
        return (Math.abs(ap.x - x) + Math.abs(ap.y - y)) <= ap.c ? true : false;
    }

    static class AP{
        int id;

        int x;
        int y;
        int c;
        int p;
        public AP() {}

        public AP(int id, int y, int x, int c, int p) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }

    }
}
