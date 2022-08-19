package com.ssafy.live;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳_live {
    static int R, C;
    static int cnt, answer;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cnt = answer = 1;

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(map, new boolean[26], 0, 0); // 방문체크 배열 : A ~ Z까지의 표현(26)
        System.out.println(answer);

        br.close();
    }

    static void dfs(char[][] map, boolean[] visited, int x, int y) {
        // index에 ascii 코드 값이 들어감
        // 배열에 인덱싱 관리하기 위해 65를 빼줌.
        int idx = map[x][y] - 'A';

        visited[idx] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < R && ny >= 0 && ny < C){
                int next = map[nx][ny] - 'A';

                if(!visited[next]) {
                    answer = Math.max(++cnt, answer);
                    dfs(map, visited, nx, ny);
                }
            }
        }
        cnt -= 1;
        visited[idx] = false;
    }
}
