package com.ssafy.live;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 완전 이진 트리 구현
public class CompleteBinaryTree {
    private char[] nodes;
    private int lastIndex = 0;
    private final int SIZE;

    public CompleteBinaryTree(int size) {
        SIZE = size;
        nodes = new char[size + 1]; // 편의를 위해 1 인덱스부터 사용
    }

    public boolean add(char e){ // 완전이진트리에 맞게 추가
        if(lastIndex == SIZE) return false; // 포화 상태라면

        nodes[++lastIndex] = e;
        return true;
    }

    public void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 루트노드 인덱스 부터

        while(!queue.isEmpty()){ // 방문 대상이 있다면 반복
            int current = queue.poll(); // 방문 노드 정보
            System.out.print(nodes[current] + " ");

            // 현재 방문 노드의 자식이 있다면
            // 왼쪽 자식이 마지막 인덱스보다 작거나 같다면, 범위 안에 있으므로 존재한다.
            if(current * 2 <= lastIndex) queue.offer(current * 2);
            // 오른쪽 자식이 마지막 인덱스보다 작거나 같다면, 범위 안에 있으므로 존재한다.
            if(current * 2 + 1 <= lastIndex) queue.offer(current * 2 + 1);
        }
        System.out.println();
    }

    public void bfs2(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 루트노드 인덱스 부터

        while(!queue.isEmpty()){ // 방문 대상이 있다면 반복
            int size = queue.size();

            while(--size >= 0){
                int current = queue.poll(); // 방문 노드 정보
                System.out.print(nodes[current] + " ");

                // 현재 방문 노드의 자식이 있다면
                // 왼쪽 자식이 마지막 인덱스보다 작거나 같다면, 범위 안에 있으므로 존재한다.
                if(current * 2 <= lastIndex) queue.offer(current * 2);
                // 오른쪽 자식이 마지막 인덱스보다 작거나 같다면, 범위 안에 있으므로 존재한다.
                if(current * 2 + 1 <= lastIndex) queue.offer(current * 2 + 1);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void dfs(){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1); // 루트노드 인덱스 부터

        while(!stack.isEmpty()){ // 방문 대상이 있다면 반복
            int current = stack.pop(); // 방문 노드 정보
            System.out.print(nodes[current] + " ");

            // 현재 방문 노드의 자식이 있다면
            // 왼쪽 자식이 마지막 인덱스보다 작거나 같다면, 범위 안에 있으므로 존재한다.
            if(current * 2 <= lastIndex) stack.push(current * 2);
            // 오른쪽 자식이 마지막 인덱스보다 작거나 같다면, 범위 안에 있으므로 존재한다.
            if(current * 2 + 1 <= lastIndex) stack.push(current * 2 + 1);
        }
        System.out.println();
    }
}
