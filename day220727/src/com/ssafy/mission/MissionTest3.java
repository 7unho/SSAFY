package com.ssafy.mission;

import java.util.Random;

public class MissionTest3 {
    public static void main(String[] args) {
        int[] lotto = new int[45];
        Random r = new Random();

        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = i + 1;
        }

        int temp;

        for (int i = 0; i < 1000 ; i++) {
            int changeIdx = r.nextInt(44) + 1;
            temp = lotto[0];
            lotto[0] = lotto[changeIdx];
            lotto[changeIdx] = temp;
        }

        for (int i = 0; i < 6; i++) {
            System.out.printf("%d ", lotto[i]);
        }
    }
}
