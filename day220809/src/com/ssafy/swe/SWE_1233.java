package com.ssafy.swe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_1233 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("day220809/res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N;
        int answer;

        for (int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(br.readLine());
            answer = 1;

            // 자식이 있다면, 연산자를 가져야 하고, 자식이 없다면 숫자여야 한다..
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                char temp = st.nextToken().charAt(0);
                if (st.countTokens() >= 1 && Character.isDigit(temp)) {
                    answer = 0;
                    continue;
                }

                if (st.countTokens() == 0 && !Character.isDigit(temp)){
                    answer = 0;
                    continue;
                }

            }
            System.out.printf("#%d %d\n", tc, answer);
        }
    }
}
