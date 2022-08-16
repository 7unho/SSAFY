package com.ssafy.live;

import java.util.Scanner;

public class 동전자판기_Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetMoney = sc.nextInt();

        int[] units = {500, 100, 50, 10, 5, 1};
        int[] counts = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};

        int totalMoney = 0;
        for (int i = 0, size = units.length; i < size; i++) {
            totalMoney += units[i] * counts[i];
        }

        int remainMoney = totalMoney - targetMoney;

        int sum = 0, maxCnt, availCnt;
        for (int i = 0, size = units.length; i < size; i++) {
            maxCnt = remainMoney / units[i];
            availCnt = (maxCnt <= counts[i]) ? maxCnt : counts[i];

            counts[i] -= availCnt;
            remainMoney -= availCnt * units[i];

            sum += counts[i];
        }

        System.out.println(sum);

        for (int i = 0, size = counts.length; i < size; i++) {
            System.out.print(counts[i] + " ");
        }
    }
}