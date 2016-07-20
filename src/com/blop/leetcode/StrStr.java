package com.blop.leetcode;

/**
 * Created by tenghuanhe on 2016/7/17.
 */
public class StrStr {
    public static void main(String[] args) {

        System.out.println(strStr("", ""));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (needle.equals(haystack.substring(i, i + needle.length()))) {
                return i;
            }
        }

        return -1;
    }
}
