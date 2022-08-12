package com.ssafy.live;

import java.util.Scanner;

public class Main_2961_도영이가_만든_맛있는_음식 {
    static int N, answer = Integer.MAX_VALUE;
    static Food[] foods;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        foods = new Food[N];

        for (int i = 0; i < N; i++) {
            foods[i] = new Food(sc.nextInt(), sc.nextInt());
        }

        Solution(0, 1, 0);
        System.out.println(answer);
        sc.close();
    }

    static void Solution(int depth, int sour, int bitter){
        if(depth == N) {

            if(sour == 1 && bitter == 0) return;

            answer = Math.min(answer, Math.abs(sour - bitter));
            return;
        }

        Solution(depth + 1, sour * foods[depth].sour, bitter + foods[depth].bitter);
        Solution(depth + 1, sour, bitter);
    }

}

class Food{
    int sour;
    int bitter;

    public Food(int sour, int bitter) {
        this.sour = sour;
        this.bitter = bitter;
    }

    @Override
    public String toString() {
        return "Food{" +
                "sour=" + sour +
                ", bitter=" + bitter +
                '}';
    }
}

