package com.april2nds.swe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1244 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] sw = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            sw[i] = Integer.parseInt(st.nextToken());
        }

        int S = Integer.parseInt(br.readLine());
        for(int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(gender == 1) {
                int count = 1;
                while(num * count <= N) {
                    sw[num * count] = 1 - sw[num * count] ;
                    count++;
                }
            } else {
                int start = num-1;
                int end = num+1;
                while(start >=1 && end <=N) {
                    if(sw[start] != sw[end]) break;
                    start--;
                    end++;
                }
                start++; end--;

                for(int j = start; j <= end; j++) {
                    sw[j] = 1 - sw[j];
                }
            }
        }
        for(int i = 1; i<=N; i++) {
            bw.write(sw[i] + " ");
            if(i % 20 == 0) {
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
