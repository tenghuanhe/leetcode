package com.blop.leetcode;

import java.util.Arrays;

/**
 * Created by tenghuanhe on 2016/7/17.
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[100];
        nums1[0] = 1;
        nums1[1] = 1;
        nums1[2] = 1;
        nums1[3] = 1;
        nums1[4] = 1;
        nums1[5] = 1;

        int[] nums2 = {2, 6, 9};

        merge(nums1, 6, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArray = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k] = nums1[i];
                i++;
            } else {
                mergedArray[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            mergedArray[k++] = nums1[i++];
        }

        while (j < n) {
            mergedArray[k++] = nums2[j++];
        }

        System.arraycopy(mergedArray, 0, nums1, 0, m + n);
    }
}
