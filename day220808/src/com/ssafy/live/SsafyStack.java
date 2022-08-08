package com.ssafy.live;

public class SsafyStack<E> implements IStack<E>{
    private Node<E> top; // 첫 번째 노드를 저장할 변수 top
                         // 더미노드가 아님 !!

    @Override
    public void push(E data) { // 첫 노드 삽입 알고리즘
        top = new Node<E>(data, top);
    }

    @Override
    public E pop() {
        if(isEmpty()){
            System.err.println("공백 스택이므로 작업이 불가능합니다!");
            return null;
        }

        Node<E> popNode = top;
        top = popNode.link;
        popNode.link = null;
        return popNode.data;
    }

    @Override
    public E peek() {
        if(!isEmpty()) return top.data;

        System.err.println("공백 스택이므로 작업이 불가능합니다!");
        return null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        int cnt = 0;

        for (Node<E> node = top; node.link != null; node = node.link) {
            ++cnt;
        }
        return cnt;
    }
}
