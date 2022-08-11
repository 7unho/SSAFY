package com.ssafy.live;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutationTest {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int[] input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        do{
            System.out.println(Arrays.toString(input));
        } while(np(input));
    }

    public static boolean np(int[] numbers){ // numbers 배열의 상태를 근거로 다음 순여 생성, 다음 순열이 존재 : true, 아니면 : false.
        // 1. 꼭대기 찾기
        int i = N - 1;
        while(i > 0 && numbers[i - 1] >= numbers[i]) i -= 1; // 지금 원소가 첫 번쨰 원소라면 앞에 원소가 없으므로, 0보다 클때만

        // i 가 0이다 -> 첫번째 자리까지 순열 생성이 완료되었다.
        if(i == 0) return false; // 더이상 만들 수 있는 순열이 없을 떄, false를 리턴


        // 2. 꼭대기의 바로 앞자리(i - 1)의 값을 크게 만들 교환 값을 뒤쪽에서 찾기
        int j = N - 1;
        while(numbers[i - 1] >= numbers[j]) j -= 1;

        // 3. (i - 1)의 값과 j 위치값 교환
        swap(numbers, (i - 1), j);

        // 4. (i)위치부터 맨 뒤까지의 수열을 가장 작은 형태의 오름차순으로 변경
        int k = N - 1;
        while(i < k){
            swap(numbers, i++, k--); // i는 오른쪽으로 이동하면서, k는 왼쪽으로 이동해야 하기 떄문에. start, end 개념
        }
        // 다음 순열을 만들 수 있으므로 true 리턴
        return true;
    }

    public static void swap(int[] numbers, int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
