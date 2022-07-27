package com.ssafy.mission;

import java.util.Arrays;
import java.util.Random;

public class MissionTest2 {
    public static int[] lotto = new int[6];

    public static boolean isDuplicateNum(int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (lotto[index] == lotto[i]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("★★ 금주 행운의 로또번호 ★★");

        for(int tc = 1; tc <= 6; tc ++){

            Random r = new Random();

            for (int i = 0; i < lotto.length; i++) {
                lotto[i] = r.nextInt(45) + 1;
                if (isDuplicateNum(i)) i -= 1;
            }

            Arrays.sort(lotto);

            System.out.printf("%d회 : ", tc);

            for (int i = 0; i < 6; i++) {
                System.out.printf("%d", lotto[i]);
                if (i != 5) System.out.printf(", ");
                else System.out.println();
            }
        }
    }
}
