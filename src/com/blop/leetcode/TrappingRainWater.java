package com.blop.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tenghuanhe on 2016/7/19.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] height = {4, 4, 4, 7, 1, 0};
//        int[] height = {5, 4, 1, 2};
//        int[] height = {5, 2, 1, 2, 1, 5};
        int[] height = {2, 6, 3, 8, 2, 7, 2, 5, 0};
        System.out.println(trap(height));
        System.out.println(trap2(height));
    }

    public static int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int i = 0, pre = -1;
        List<Integer> v = new LinkedList<>();

        while (i < height.length && pre <= height[i]) {
            pre = height[i];
            i++;
        }

        v.add(i - 1);
        int curr = height[i - 1];
        int tMax = -1;
        int iMax = -1;

        while (i < height.length - 1) {
            i++;
            int h = height[i];
            if (h > tMax) {
                tMax = h;
                iMax = i;
            }
            if (h > curr) {
                v.add(i);
                curr = h;
            }
            if (i == height.length - 1 && iMax != -1) {
                curr = tMax;
                i = iMax;
                v.add(i);
                iMax = -1;
                tMax = 0;
            }
        }

        int result = 0;
        for (int j = 0; j < v.size() - 1; j++) {
            int left = v.get(j);
            int right = v.get(j + 1);
            if (right - left > 1) {
                int waterHeight = Math.min(height[left], height[right]);
                for (int k = left + 1; k < right; k++) {
                    if (waterHeight > height[k]) {
                        result += waterHeight - height[k];
                    }
                }
            }
        }

        return result;
    }

    public static int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int result = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    result += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    result += maxRight - height[right];
                }

                right--;
            }
        }

        return result;
    }
}
