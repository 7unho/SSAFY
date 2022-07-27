package com.ssafy.mission;

import java.util.*;

public class MissionTest {
    public static void main(String[] args) {
        System.out.println("★★ 금주 행운의 로또번호 ★★");
        for (int tc = 1; tc <= 5; tc++) {
            Set<Integer> lottoSet = new HashSet<>();
            List<Integer> lottoList;
            Random r = new Random();

            while(lottoSet.size() <= 6){
                lottoSet.add(r.nextInt(45) + 1);
            }

            lottoList = new ArrayList<>(lottoSet);
            Collections.sort(lottoList);

            System.out.printf("%d회 : ", tc);
            for (int i = 0; i < 6; i ++) {
                System.out.printf("%d", lottoList.get(i));
                if(i != 5) System.out.printf(", ");
                else System.out.println();
            }
        }
    }
}
