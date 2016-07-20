package com.blop.leetcode;

import java.util.HashMap;

/**
 * Created by tenghuanhe on 2015/11/2.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] res = new int[2];

        res = twoSum(nums, target);
        sort(nums);
        for (int i : nums)
            System.out.println(i);
        String str = "-10";
        int i;
        try {
            i = Integer.valueOf(str);
        } catch (NumberFormatException e)
        {
            i = 0;
        }

        System.out.println(i);
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(i, nums[i]);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsValue(target - nums[i])) {
//
//                res[0] = i + 1;
//                res[1] = map.get(target - nums[i]) + 1;
//
//                System.out.println(res[0]);
//                System.out.println(res[1]);
//                break;
//            }
//        }

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] + nums[j] == target) break;
            else if (nums[i] + nums[j] > target) j--;
            else i++;
        }

        res[0] = i + 1;
        res[1] = j + 1;

        return res;
    }

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(nums, lo, hi);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }

    public static int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = nums[lo];
        int tmp;
        while (true) {
            while (nums[++i] < v) if (i == hi) break;
            while (nums[--j] > v) if (j == lo) break;

            if (i >= j) break;
            {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        tmp = nums[lo];
        nums[lo] = nums[j];
        nums[j] = tmp;

        return j;
    }
}
