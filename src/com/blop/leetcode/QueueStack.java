package com.blop.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by tenghuanhe on 2016/7/19.
 */
public class QueueStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public QueueStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public static void main(String[] args) {
        QueueStack qStack = new QueueStack();
        qStack.push(1);
        qStack.push(2);
        qStack.push(4);
        qStack.push(3);
        qStack.push(9);

        System.out.println(qStack.top());
        qStack.pop();
        System.out.println(qStack.top());
        qStack.pop();
        System.out.println(qStack.top());
        qStack.pop();
        System.out.println(qStack.top());
        qStack.pop();
        System.out.println(qStack.top());
        qStack.pop();
        System.out.println(qStack.empty());
        qStack.push(5);
        System.out.println(qStack.empty());
    }

    public void push(int x) {
        if (q1.isEmpty() && (!q2.isEmpty())) {
            q2.add(x);
        } else if (q2.isEmpty() && (!q1.isEmpty())) {
            q1.add(x);
        } else if (q1.isEmpty() && q2.isEmpty()) {
            q1.add(x);
        } else if ((!q1.isEmpty()) && (!q2.isEmpty())) {
            // Error
        }
    }

    public void pop() {
        int x;
        if (q1.isEmpty() && (!q2.isEmpty())) {
            x = q2.poll();
            while (!q2.isEmpty()) {
                q1.add(x);
                x = q2.poll();
            }
            return;
        }
        if (q2.isEmpty() && (!q1.isEmpty())) {
            x = q1.poll();
            while (!q1.isEmpty()) {
                q2.add(x);
                x = q1.poll();
            }
            return;
        }
    }

    public int top() {
        int x = 0;
        if (q1.isEmpty() && (!q2.isEmpty())) {
            x = q2.poll();
            while (!q2.isEmpty()) {
                q1.add(x);
                x = q2.poll();
            }
            q1.add(x);
            return x;
        }
        if (q2.isEmpty() && (!q1.isEmpty())) {
            x = q1.poll();
            while (!q1.isEmpty()) {
                q2.add(x);
                x = q1.poll();
            }
            q2.add(x);
            return x;
        }

        return x;
    }

    public boolean empty() {
        return (q1.isEmpty() && q2.isEmpty());
    }
}
