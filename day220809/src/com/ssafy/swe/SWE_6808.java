package com.ssafy.swe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWE_6808 {
    public static int[] kyuYoung, inYoung;
    public static boolean[] cards;
    public static int Win, Lose;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("day220809/res/s_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            cards = new boolean[19];
            kyuYoung = new int[9];
            inYoung = new int[9];

            Win = 0;
            Lose = 0;
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 9; i++) {
                kyuYoung[i] = Integer.parseInt(st.nextToken());
                cards[kyuYoung[i]] = true;
            }

            int j = 0;
            for (int i = 1; i <= 18; i++) {
                if(!cards[i]) inYoung[j++] = i;
            }

            Solution(0, 0, 0);

            System.out.printf("#%s %d %d\n", tc, Win, Lose);
        }

    }

    public static void Solution(int depth, int winSum, int loseSum){
        if(depth >= 9){
            if(winSum > loseSum) Win += 1;
            else if(loseSum > winSum) Lose += 1;
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (cards[inYoung[i]]) continue;

            cards[inYoung[i]] = true;

            if(inYoung[i] > kyuYoung[depth]) Solution(depth + 1, winSum, loseSum + inYoung[i] + kyuYoung[depth]);
            else if(kyuYoung[depth] > inYoung[i]) Solution(depth + 1, winSum + inYoung[i] + kyuYoung[depth], loseSum);

//            if(inYoung[i] > kyuYoung[depth]) loseSum += inYoung[i] + kyuYoung[depth];
//            else if(kyuYoung[depth] > inYoung[i]) winSum += inYoung[i] + kyuYoung[depth];
//
//            Solution(depth + 1, winSum, loseSum);
            cards[inYoung[i]] = false;
        }
    }
}
