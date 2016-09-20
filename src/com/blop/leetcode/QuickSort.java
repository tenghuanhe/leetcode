package com.blop.leetcode;

import java.util.Arrays;

/**
 * Created by tenghuanhe on 2016/7/28.
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 7, 2, 4, 5, 10, 8};
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11, 111, 1, 1, 1, 1, 1111};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = arr[l];
            while (i < j) {
                while (i < j && arr[j] >= x) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }

                while (i < j && arr[i] <= x) {
                    i++;
                }

                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }

            arr[i] = x;

            quickSort(arr, l, i - 1);
            quickSort(arr, i + 1, r);
        }
    }
}
