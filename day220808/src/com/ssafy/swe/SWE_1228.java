package com.ssafy.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWE_1228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Integer> array;
        String[] query;

        for(int tc = 1; tc <= 10; tc ++){
            array = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                array.add(Integer.parseInt(st.nextToken()));
            }

            int query_N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "I", false);
            for (int i = 0; i < query_N; i++) {
                String str = st.nextToken();
                query = str.split(" ");
                System.out.println(Arrays.toString(query));

                for (int j = 0; j < Integer.parseInt(query[2]); j++) {
                    array.add(Integer.parseInt(query[1]) + j, Integer.parseInt(query[j + 3]));
                }
                System.out.println(array.toString());
            }

            System.out.printf("#%d ", tc);
            for (int i = 0; i < 10; i++) {
                System.out.print(array.get(i) + " ");
            }
            System.out.println();
        }
    }
}
