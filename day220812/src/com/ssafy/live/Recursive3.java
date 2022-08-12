package com.ssafy.live;

public class Recursive3 {
//    static int[] arr;
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9};
        recursive(arr, 0, 0);
    }

    public static void recursive(int[] arr, int depth, int sum){
        if(depth >= arr.length){
            System.out.println(sum);
            return;
        }
        recursive(arr,depth + 1, sum + arr[depth]);
    }
}
