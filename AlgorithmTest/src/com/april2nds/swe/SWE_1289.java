package com.april2nds.swe;

import java.util.Scanner;

public class SWE_1289 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        sc.nextLine();

        for (int tc = 1; tc <= TC; tc++) {
            String[] target = sc.nextLine().split("");

            System.out.println("test");

            int[] base = new int[target.length];

            int answer = 0;

            for (int i = 0; i < base.length; i++) {
                if (base[i] != Integer.parseInt(target[i])) {
                    for (int j = i; j < base.length; j++) {
                        base[j] = 1 - base[j];
                    }
                    answer += 1;
                }
            }

            System.out.printf("#%d %d\n", tc, answer);
        }
    }
}
