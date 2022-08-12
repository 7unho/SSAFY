package com.ssafy.live;

public class Recursive4 {
//    static int[] arr;
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9};
        recursive(arr, 0, 1);
    }

    public static void recursive(int[] arr, int depth, int multi){
        if(depth >= arr.length){
            System.out.println(multi);
            return;
        }
        recursive(arr,depth + 1, multi * arr[depth]);
    }
}
