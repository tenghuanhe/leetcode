package com.blop.leetcode;

import java.util.Stack;

/**
 * Created by tenghuanhe on 2016/7/19.
 */
public class ParenValid {
    public static void main(String[] args) {
        System.out.println(isValid("[]{}()[}()]"));
    }

    private static boolean isValid(String s) {
        if (s.equals("") || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (stack.empty()) {
                if (c == '}' || c == ']' || c == ')') {
                    return false;
                }

                stack.push(c);
            } else {
                if (c == '{' || c == '[' || c == '(') {
                    stack.push(c);
                } else {
                    if (c == '}') {
                        if (stack.peek() == '{') {
                            stack.pop();
                        } else {
                            return false;
                        }
                    } else if (c == ']') {
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else {
                            return false;
                        }
                    } else if (c == ')') {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                }

            }
        }

        return stack.empty();
    }
}
