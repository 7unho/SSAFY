package com.april2nds.swe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWE_1873 {
    // . 평지
    // * 벽돌
    // # 강철
    // - 물
    static int rows, cols, cmdCnt;
    static char[][] map;
    static char[] cmds;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("day220803/res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        String str;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC ; tc++) {
            str = br.readLine();
            st = new StringTokenizer(str);

            rows = Integer.parseInt(st.nextToken());
            cols = Integer.parseInt(st.nextToken());

            map = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                str = br.readLine();
                for (int j = 0; j < cols; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            cmdCnt = Integer.parseInt(br.readLine());
            cmds = br.readLine().toCharArray();

            for (int i = 0; i < cmds.length; i++) {
                move(cmds[i]);
            }

            System.out.printf("#%d ", tc);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }

    }

    public static void move(char command){
        int cur_x = 0;
        int cur_y = 0;
        int nx = 0;
        int ny = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(map[i][j] == '<' || map[i][j] == 'v' || map[i][j] == '^' ||map[i][j] == '>') {
                    cur_x = i;
                    cur_y = j;
                }
            }
        }

        switch (command){
            case 'U':
                map[cur_x][cur_y] = '^';
                nx = cur_x - 1;
                ny = cur_y;
                break;
            case 'D':
                map[cur_x][cur_y] = 'v';
                nx = cur_x + 1;
                ny = cur_y;
                break;
            case 'L':
                map[cur_x][cur_y] = '<';
                nx = cur_x;
                ny = cur_y - 1;
                break;
            case 'R':
                map[cur_x][cur_y] = '>';
                nx = cur_x;
                ny = cur_y + 1;
                break;
            case 'S':
                shoot(map[cur_x][cur_y], cur_x, cur_y);
                break;
        }

        if ((nx >= 0 && nx < rows && ny >= 0 && ny < cols) && map[nx][ny] == '.'){
            map[nx][ny] = map[cur_x][cur_y];
            map[cur_x][cur_y] = '.';
        }
    }
    public static void shoot(char direction, int x, int y){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int dir_idx = 0;
        int target_x = 0;
        int target_y = 0;

        switch (direction){
            case '^':
                dir_idx = 0;
                break;
            case 'v':
                dir_idx = 1;
                break;
            case '<':
                dir_idx = 2;
                break;
            case '>':
                dir_idx = 3;
                break;
        }

        while(true){
            x = x + dx[dir_idx];
            y = y + dy[dir_idx];

            if (x < 0 || y < 0 || x >= rows || y >= cols) break;

            if(map[x][y] == '*' || map[x][y] == '#') {
                target_x = x;
                target_y = y;
                break;
            }
        }

        if (map[target_x][target_y] == '*') map[target_x][target_y] = '.';
    }
}
