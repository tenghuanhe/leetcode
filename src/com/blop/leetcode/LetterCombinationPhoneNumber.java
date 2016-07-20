package com.blop.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by tenghuanhe on 2016/7/16.
 */
public class LetterCombinationPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("") || digits.length() == 0) {
            return null;
        }

        Map<Character, String> phoneNumber = new HashMap<>();
        phoneNumber.put('0', "0");
        phoneNumber.put('1', "1");
        phoneNumber.put('2', "abc");
        phoneNumber.put('3', "def");
        phoneNumber.put('4', "ghi");
        phoneNumber.put('5', "jkl");
        phoneNumber.put('6', "mno");
        phoneNumber.put('7', "pqrs");
        phoneNumber.put('8', "tuv");
        phoneNumber.put('9', "wxyz");

        // FIFO algorithms
        LinkedList<String> result = new LinkedList<>();
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            Character c = digits.charAt(i);
            while (result.peek().length() == i) {
                String t = result.remove();
                for (char s : phoneNumber.get(c).toCharArray()) {
                    result.add(t + s);
                }
            }
        }

        return result;
    }

}
