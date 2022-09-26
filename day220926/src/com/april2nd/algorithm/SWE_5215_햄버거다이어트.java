package com.april2nd.algorithm;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWE_5215_햄버거다이어트 {
    static int N, L;
    static int[] T, K;
    static int res;
    public static void main(String[] args) throws FileNotFoundException {
//      System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in); //키보드
        int TC = sc.nextInt();
        for(int t = 1 ; t <= TC; t++) {
            res = 0; //초기값, 최대값(초기값=> 최소값), 최소값(초기값=>최대값)

            //입력
            N = sc.nextInt(); //재료의 수, 
            L = sc.nextInt(); //제한 칼로리
            T = new int[N]; //맛 만족도 배열
            K = new int[N]; //칼로리 배열

            for(int i = 0; i < N; i++) {
                T[i]= sc.nextInt();
                K[i]= sc.nextInt();
            }
            //입력확인
//          for(int i = 0; i < N; i++) {
//              System.out.println(T[i] + " , " + K[i]);
//          }


            //문제해결
            solve(0,0,0);
            //출력
//          #1 750
            System.out.println("#"+t + " " + res);
        }

    }
    static void solve(int idx,int sumT, int sumK){ //현재위치에서 재료를 선택하거나 안하거나, 맛 만족값, 칼로리합
        //종료2 : 중간 칼로리의 합이 제한된 L보다 크다면 그냥 종료
        if(sumK > L) { //중간에 의미가 없어지는 경우 나머지 실행 정지
            return;
        }
        //종료1 : 모든 재료를 확인했음 => 정상적 모든 경우 확인
        if(idx == N) {
            //boolean 배열을 생성(X) , 만족도의 합, 그때의 재료 구성(X)
            //만족도 판단
            res = Math.max(res, sumT);
//          if(res < sumT) {
//              res = sumT;
//          }
            return;
        }
        //실행 및 재귀호출
//      현재 위치의 재료 선택하는 경우
        solve(idx + 1, sumT + T[idx], sumK + K[idx]);

//      현재 위치의 재료 선택 안하는 경우
        solve(idx + 1, sumT, sumK);
    }


}