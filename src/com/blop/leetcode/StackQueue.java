package com.blop.leetcode;

import java.util.Stack;

/**
 * Created by tenghuanhe on 2016/7/19.
 */
public class StackQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public static void main(String[] args) {
        StackQueue sQueue = new StackQueue();
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
        // move elements from stack2 to stack1
        // push x into stack2
        // move elements from stack1 to stack2
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }

        stack1.push(x);
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }

    }

    public void pop() {
        stack2.pop();

    }

    public int peek() {
        return stack2.peek();
    }

    public boolean empty() {

        return stack2.empty();

    }

}
