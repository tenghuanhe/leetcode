package com.blop.leetcode;

/**
 * Created by tenghuanhe on 2015/11/2.
 */
public class LongestString {
    public static void main(String[] args) {
        String str = "2147483648";
        int i;
        Long res;
        for (i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!((c >= '0' && c <= '9') || c == '-' || c == '+' || c == ' ' || c == '\t'))
                break;
        }

        str = str.substring(0, i);
        try {
            res = Long.valueOf(str.trim());
        } catch (NumberFormatException nfe) {
            res = 0L;
        }

//        Integer.valueOf("-2147483649");

        System.out.println(lengthOfLongestSubstring("abcadegf"));

        System.out.println(isPalindromeString("abcba"));
        System.out.println(isPalindromeString("abccba"));
        System.out.println(isPalindromeString("abcccba"));
        System.out.println(isPalindromeString("1"));

        System.out.println(longestPalindrome("abccba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxlen;

        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        int start = 0;
        String sbstr = s.substring(0, 1);
        maxlen = 1;

        for (int i = 1; i < s.length(); i++) {
            int j = sbstr.indexOf(s.charAt(i));
            if (j >= 0)
                start += j + 1;
            sbstr = s.substring(start, i + 1);
            maxlen = Math.max(maxlen, sbstr.length());
        }
        return maxlen;
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        int maxlen = 1;
        int maxi = 0;
        int maxj = 1;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxlen; j <= s.length(); j++) {
                if (isPalindromeString(s.substring(i, j)) && (maxlen < j - i)) {
                    maxi = i;
                    maxj = j;
                    maxlen = maxj - maxi;
                }
            }
        }
        return s.substring(maxi, maxj);
    }

    public static boolean isPalindromeString(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
