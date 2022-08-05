package com.april2nds.swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWE_1218 {
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, answer;
        String query;

        for (int tc = 1; tc <= 10 ; tc++) {
            N = Integer.parseInt(br.readLine());
            query = br.readLine();
            answer = 1;

            stack = new Stack<>();

            for (int i = 0; i < N; i++) {
                if(!Solution(query.charAt(i))) {
                    answer = 0;
                    break;
                }
            }

            System.out.printf("#%d %dn", tc, answer);
        }

    }

    public static boolean Solution(char ch){
        boolean flag = true;
        switch (ch){
            case '(':
            case '[':
            case '{':
            case '<':
                stack.push(ch);
                break;
            case ')':
                if(stack.peek() != '('){
                    flag = false;
                } else stack.pop();
                break;
            case ']':
                if(stack.peek() != '['){
                    flag = false;
                } else stack.pop();
                break;
            case '}':
                if(stack.peek() != '{'){
                    flag = false;
                } else stack.pop();
                break;
            case '>':
                if(stack.peek() != '<'){
                    flag = false;
                } else stack.pop();
                break;
        }

        return flag;
    }
}
