package com.blop.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tenghuanhe on 2016/7/19.
 */
public class MinStack {
    private List<Integer> dataList;
    private List<Integer> minList;

    public MinStack() {

        dataList = new ArrayList<>();
        minList = new ArrayList<>();

    }

    public void push(int x) {
        if (dataList.isEmpty()) {
            dataList.add(x);
            minList.add(x);
        } else {
            dataList.add(x);
            int currMin = minList.get(minList.size() - 1);
            if (x < currMin) {
                minList.add(x);
            } else {
                minList.add(currMin);
            }
        }

    }

    public void pop() {
        dataList.remove(dataList.size() - 1);
        minList.remove(minList.size() - 1);
    }

    public int top() {
        return dataList.get(dataList.size() - 1);
    }

    public int getMin() {
        return minList.get(minList.size() - 1);
    }
}
