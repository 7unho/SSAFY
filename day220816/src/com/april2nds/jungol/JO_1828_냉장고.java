package com.april2nds.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1828_냉장고 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        Freezer[] f = new Freezer[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());

            f[i] = new Freezer(low, high);
        }

        Arrays.sort(f);
        Freezer temp = f[0];
        for (int i = 1; i < N; i++) {
            if(temp.high < f[i].low){
                cnt += 1;
                temp = f[i];
            }
        }

        System.out.println(cnt);
    }

    static class Freezer implements Comparable<Freezer>{
        int low;
        int high;

        public Freezer(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public int compareTo(Freezer o){
            return this.high - o.high;
        }
    }
}
