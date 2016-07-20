package com.blop.leetcode;

/**
 * Created by tenghuanhe on 2016/7/19.
 */
public class ReverseVowelsStr {
    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        if (s.equals("") || s.length() == 0) {
            return s;
        }

        int[] vindice = new int[s.length()];
        char[] vchars = new char[s.length()];
        char[] result = new char[s.length()];

        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            result[i] = c;
            if (isVowel(c)) {
                vindice[j] = i;
                vchars[j] = c;
                j++;
            }
        }

        int vlen = j;
        for (int i = 0; i < vlen; i++) {
            result[vindice[i]] = vchars[vlen - i - 1];
        }

        return new String(result);
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
