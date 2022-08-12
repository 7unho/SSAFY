package com.ssafy.live;

public class Recursive2 {
//    static int[] arr;
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9};
        recursive(arr, 0);
    }

    public static void recursive(int[] arr, int depth){
        if(depth >= arr.length){
            return;
        }
        System.out.println(arr[depth]);
        recursive(arr,depth + 1);
    }
}
