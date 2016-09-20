package com.blop.leetcode;

/**
 * Created by tenghuanhe on 2016/7/29.
 */
public class BinarySearchTree {
    public TreeNode root;

    public static void main(String[] args) {
    }

    public boolean find(int id) {
        TreeNode current = root;
        while (current != null) {
            if (current.val == id) {
                return true;
            } else if (current.val > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }
}
