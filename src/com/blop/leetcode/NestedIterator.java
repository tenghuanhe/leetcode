package com.blop.leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by tenghuanhe on 2016/7/19.
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<Iterator<NestedInteger>> stack;
    NestedInteger nextInt;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.iterator());
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
            } else {
                NestedInteger x = stack.peek().next();
                if (x.isInteger()) {
                    return true;
                } else {
                    stack.push(x.getList().iterator());
                }
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        return nextInt != null ? nextInt.getInteger() : null;
    }

    @Override
    public void remove() {

    }
}
