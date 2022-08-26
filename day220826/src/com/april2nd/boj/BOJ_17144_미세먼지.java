package com.april2nd.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지 {
    static int R, C, T, answer;
    static int[][] map, temp;


    // 공기청정기 좌표 정보를 담을 배열
    static int[] filters = new int[2];

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        answer = 0;

        map = new int[R][C];

        int idx = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // -1이 입력되었다면 해당 x좌표 filters에 저장
                if(map[i][j] == -1) filters[idx++] = i;
            }
        }

        for (int i = 0; i < T; i++) {
            // T번 반복 수행할 때 마다, 2차원 배열 초기화 후,
            // 공기청정기 좌표값에 -1 초기화
            temp = new int[R][C];
            temp[filters[0]][0] = -1;
            temp[filters[1]][0] = -1;

            // 미세먼지 확산 진행
            Solution1();

            // 배열 회전 진행
            Solution2();

        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 모든 연산이 마친 배열의 값을 확인하여 0 보다 크다면 answer에 누적
                if(map[i][j] >= 0) answer += map[i][j];
            }
        }

        System.out.println(answer);
    }

    // 구현 1, 전체 미세먼지 확산 먼저 하면서. 확산 누적값 저장
    static void Solution1(){
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {

                // 현재 좌표에 공기청정기가 있다면 미세먼지 확산할 필요가 없으므로 return
                if(map[x][y] == -1) continue;

                int sum = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    // 탐색할 좌표가 배열 인덱스 범위 안에 있으며, 해당 좌표에 공기청정기가 없을 때,
                    if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] >= 0){

                        // 현재 좌표의 데이터 값 / 5 한 값을 탐색할 좌표들에 더해주면서
                        // Sum 변수에 누적합을 진행
                        temp[nx][ny] += map[x][y] / 5;
                        sum += map[x][y] / 5;
                    }
                }

                // 원래의 데이터값에 누적된 Sum변수 값을 제하여 저장
                temp[x][y] += map[x][y] - sum;
            }
        }

        // map을 temp로 바꿔준다.
        map = temp;
    }

    // 구현 2, 바람 순회
    static void Solution2(){


        // 반시계 방향
        // 1. 아래로 부는 바람
        for (int x = filters[0] - 1; x > 0; x--) {
            map[x][0] = map[x - 1][0];
        }

        // 2. 왼쪽으로 부는 바람
        for (int y = 0; y < C - 1; y++) {
            map[0][y] = map[0][y + 1];
        }

        // 3. 위로 부는 바람
        for (int x = 0; x < filters[0]; x++) {
            map[x][C - 1] = map[x + 1][C - 1];
        }

        // 4. 오른쪽으로 부는 바람
        for (int y = C - 1; y > 1; y--) {
            map[filters[0]][y] = map[filters[0]][y - 1];
        }

        // 5. 공기청정기 오른쪽 좌표는 0을 저장
        map[filters[0]][1] = 0;


        // 시계 방향
        // 1. 위로 부는 바람
        for (int x = filters[1] + 1; x < R - 1; x++) {
            map[x][0] = map[x + 1][0];
        }

        // 2. 왼쪽으로 부는 바람
        for (int y = 0; y < C - 1; y++) {
            map[R - 1][y] = map[R - 1][y + 1];
        }


        // 3. 아래로 부는 바람
        for (int x = R - 1; x > filters[1]; x--) {
            map[x][C - 1] = map[x - 1][C - 1];
        }


        // 4. 오른쪽으로 부는 바람
        for (int y = C - 1; y > 1; y--) {
            map[filters[1]][y] = map[filters[1]][y - 1];
        }

        // 5. 공기청정기 오른쪽 좌표는 0을 저장
        map[filters[1]][1] = 0;
    }
}
