package com.ssafy.live;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JO_1828_냉장고 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 화학물질의 개수

        // N줄 동안 화학물질 담기
        // -> { -15, 5 }, { -10, 36 }, ...
        int[][] matter = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matter[i][0] = Integer.parseInt(st.nextToken());
            matter[i][1] = Integer.parseInt(st.nextToken());
        }

        // 최고 보관 온도로 sorting
        Arrays.sort(matter, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int cnt = 1; // 냉장고의 개수
        int max = matter[0][1]; // 최고 온도 저장

        for (int i = 1; i < N; i++) {
            if(max < matter[i][0]){
                cnt += 1;
                max = matter[i][1];
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
