package com.blop.leetcode;

/**
 * Created by tenghuanhe on 2016/7/31.
 */
public class BinarySearch {
    public static void main(String[] args) {

    }

    public static int binarySearch(int a[], int key) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (key == a[mid]) {
                return mid;
            } else if (key > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
