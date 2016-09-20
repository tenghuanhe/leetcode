package com.blop.leetcode;

/**
 * Created by tenghuanhe on 2016/7/31.
 */
public class LongestCommonSequence {
    public static void main(String[] args) {
        char[] str1 = {'a', 'b', 'd', 'e', 'f'};
        char[] str2 = {'d', 'e'};

        System.out.println(longestCommonSeq(str1, str2, str1.length, str2.length));
    }

    public static int longestCommonSeq(char[] str1, char[] str2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (str1[m - 1] == str2[n - 1]) {
            return longestCommonSeq(str1, str2, m - 1, n - 1) + 1;
        } else {
            return Math.max(longestCommonSeq(str1, str2, m - 1, n), longestCommonSeq(str1, str2, m, n - 1));
        }
    }
}
