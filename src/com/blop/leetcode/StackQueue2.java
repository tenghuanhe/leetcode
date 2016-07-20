package com.blop.leetcode;

import java.util.Stack;

/**
 * Created by tenghuanhe on 2016/7/19.
 */
public class StackQueue2 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackQueue2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public static void main(String[] args) {
        StackQueue2 sQueue = new StackQueue2();
        sQueue.push(1);
        sQueue.push(4);
        sQueue.push(5);
        sQueue.push(7);
        sQueue.push(2);
        System.out.println(sQueue.peek());
        sQueue.pop();
        System.out.println(sQueue.peek());
        sQueue.pop();
        System.out.println(sQueue.peek());
        sQueue.pop();
        System.out.println(sQueue.peek());
        sQueue.pop();
        System.out.println(sQueue.peek());
        sQueue.pop();
        System.out.println(sQueue.empty());
    }

    public void push(int x) {
        stack1.push(x);
    }

    public void pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();
    }

    public int peek() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

}
