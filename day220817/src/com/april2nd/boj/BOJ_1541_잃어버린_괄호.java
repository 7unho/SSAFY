package com.april2nd.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1541_잃어버린_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;
        String[] temp;

        st = new StringTokenizer(br.readLine(), "-");
        if(st.countTokens() == 1) {
            temp = st.nextToken().split("\\+");
            for (int i = 0; i < temp.length; i++) {
                answer += Integer.parseInt(temp[i]);
            }
        }
        else {
            temp = st.nextToken().split("\\+");
            answer = (temp.length == 1) ? Integer.parseInt(temp[0]) : Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]);
            while (st.hasMoreTokens()) {
                temp = st.nextToken().split("\\+");

                if (temp.length == 1) answer -= Integer.parseInt(temp[0]);
                else {
                    int sum = 0;
                    for (int i = 0; i < temp.length; i++) {
                        sum += Integer.parseInt(temp[i]);
                    }

                    answer -= sum;
                }
            }
        }

        System.out.println(answer);
    }
}
