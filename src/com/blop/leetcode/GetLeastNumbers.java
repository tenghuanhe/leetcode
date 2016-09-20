package com.blop.leetcode;

import java.util.Arrays;

/**
 * Created by tenghuanhe on 2016/7/29.
 */
public class GetLeastNumbers {
    public static void main(String[] args) {
        int arr[] = {3, 7, 9, 5, 6, 1};
        System.out.println(Arrays.toString(getLeastNumbers(arr, 3)));
    }

    public static int[] getLeastNumbers(int arr[], int k) {
        int[] result = new int[k];
        if (arr == null || arr.length == 0 || k > arr.length) {
            return result;
        }

        int start = 0;
        int end = arr.length - 1;
        int index = partition(arr, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(arr, start, end);
            } else {
                start = index + 1;
                index = partition(arr, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }

        return result;
    }

    public static int partition(int arr[], int start, int end) {
        if (start > end) {
            return 0;
        }

        int i = start, j = end, x = arr[start];

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
        return i;
    }
}
