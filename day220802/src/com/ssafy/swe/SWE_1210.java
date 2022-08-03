//package com.ssafy.swe;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SWE_1210 {
//    static int[][] ladder;
//    static int[][] visited = new int[3][3];
//
//    public static void main(String[] args) {
//        ladder = new int[][]{{1, 0, 1}, {1, 1, 1}, {2, 0, 1}};
//
//        int answer = -1;
//        List<Integer> starts = new ArrayList<>();
//
//        for (int i = 0; i < ladder.length; i++) {
//            if (ladder[0][i] == 1) starts.add(i);
//        }
//
//        for (int i = 0; i < starts.size() ; i++) {
//            if(Solution(1, starts.get(i))) answer = starts.get(i);
//        }
//
//        System.out.println(answer);
//    }
//
//    public static boolean Solution(int x, int y){
//        int[] dx = {0, 0, 1};
//        int[] dy = {1, -1, 0};
//
//        int nx, ny;
//
//        if(visited[x][y] == 0) visited[x][y] = 1;
//
//        if (x == 2) return (ladder[x][y] == 2) ? true : false;
//
////        if((y + 1) < 3 && visited[x][y + 1] == 0 && ladder[x][y + 1] == 1) return Solution(x, y + 1);
////        else if((y - 1) >= 0 && visited[x][y - 1] == 0 && ladder[x][y - 1] == 1) return Solution(x, y - 1);
////        1else return Solution(x + 1, y);
//
//        for (int i = 0; i < 3; i++) {
//            nx = x + dx[i];
//            ny = y + dy[i];
//
//            if((nx < 0 || ny < 0 || nx >= 3 || ny >= 3) && visited[nx][ny] != 0 ) continue;
//
//            if(ladder[nx][ny] > 0) return Solution(nx, ny);
//        }
//    }
//}