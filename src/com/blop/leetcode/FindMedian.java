package com.blop.leetcode;

/**
 * Created by tenghuanhe on 2016/7/19.
 */
public class FindMedian {
    public static void main(String[] args) {
//        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int arr[] = {3, 7, 9, 5, 6, 1};
        System.out.println(partition(arr, 0, arr.length - 1));
//        System.out.println(median(arr));
    }

    public static int median(int[] arr) {
        int len = arr.length;
        int middle = len >> 1;
        int start = 0;
        int end = len - 1;
        int index = partition(arr, start, end);

        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = partition(arr, start, end);
            } else {
                start = index + 1;
                index = partition(arr, start, end);
            }
        }

        int result = arr[middle];

        return result;
    }

    public static int partition(int[] arr, int start, int end) {
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
