package com.ssafy.swe;

import java.io.*;
import java.util.*;

public class SWE_9229 { // 한빈이와 Spot Mart
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("./day220808/res/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N, M, start, end;
        int TC = Integer.parseInt(br.readLine());
        List<Integer> list;

        for (int tc = 1; tc <= TC; tc++) {
            int answer = -1;
            int current = 0;
            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());


            // 과자 가방 초기화
            // 과자 1개의 무게가 M을 초과하면 가방에 담지 않음
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp < M) list.add(temp);
            }

            // 투포인터 탐색을 위해 리스트 정렬
            Collections.sort(list);

            start = 0;
            end = list.size() - 1;

            // 과자는 무조건 2개를 담아야 하기에,
            // 1. 가방에 과자가 2개 미만 있다면 -1
            // 2. 가방에 담긴 가장 적은 무게의 과자 두개가 M을 넘는다면 -1
            if(list.size() < 2 || list.get(start) + list.get(start + 1) > M) {
                System.out.printf("#%d %d\n", tc, answer);
                continue;
            }

            // 과자 2포인터 탐색
            // 1. 현재 과자 2개의 무게가 M보다 크다면, end 감소
            // 2. 현재 과자 2개의 무게가 M보다 작다면, answer로써 사용 가능하기에
            //    기존 answer와 비교 후, 큰 값을 저장하고 start 증가
            while(true){
                current = list.get(start) + list.get(end);
                if(start >= end) break;

                if(current > M){
                    end -= 1;
                    continue;
                }

                answer = Math.max(answer, current);
                start += 1;
            }

            System.out.printf("#%d %d\n", tc, answer);
        }
    }
}
