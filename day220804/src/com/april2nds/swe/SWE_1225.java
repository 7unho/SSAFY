package com.april2nds.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWE_1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            int TC = Integer.parseInt(br.readLine());

            int temp = 0;

            Queue<Integer> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            while(true){
                for (int i = 1; i <= 5; i++) {
                    temp = queue.poll();
                    temp = (temp <= i) ? 0 : temp - i;
                    queue.add(temp);
                }
                if (temp == 0) break;
            }

            System.out.printf("#%d ", TC);
            for (int i = 0; i < 8; i++) {
                System.out.printf("%d ", queue.poll());
            }
            System.out.println();

        }


    }
}
