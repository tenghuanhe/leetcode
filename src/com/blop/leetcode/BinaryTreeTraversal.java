package com.blop.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by tenghuanhe on 2016/7/19.
 */
public class BinaryTreeTraversal {
    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);

        tn1.left = tn2;
        tn1.right = tn3;
        tn2.left = tn4;
        tn4.left = tn5;
        tn3.left = tn6;

        preorderTraversalPrint(tn1);

        System.out.println(preorderTraversal(tn1));
        System.out.println(levelorderTraversal(tn1));
        System.out.println(postorderTraversal(tn1));
        System.out.println(inorderTraversal(tn1));
        System.out.println(mirrosInorderTraversal(tn1));
        System.out.println(zigzagLevelOrder(tn1));
    }

    public static void preorderTraversalPrint(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preorderTraversalPrint(root.left);
            preorderTraversalPrint(root.right);
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.empty()) {
            TreeNode treeNode = nodeStack.pop();
            result.add(treeNode.val);

            if (treeNode.right != null) {
                nodeStack.push(treeNode.right);
            }

            if (treeNode.left != null) {
                nodeStack.push(treeNode.left);
            }
        }

        return result;
    }

    public static List<Integer> levelorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        int i = 0;
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode treeNode = nodeQueue.poll();
            result.add(treeNode.val);
            if (treeNode.left != null) {
                nodeQueue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nodeQueue.add(treeNode.right);
            }
        }

        return result;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> valStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.empty()) {
            TreeNode treeNode = nodeStack.pop();
            valStack.push(treeNode.val);

            if (treeNode.left != null) {
                nodeStack.push(treeNode.left);
            }

            if (treeNode.right != null) {
                nodeStack.push(treeNode.right);
            }
        }

        while (!valStack.empty()) {
            result.add(valStack.pop());
        }

        return result;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> nodeStack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !nodeStack.empty()) {
            while (curr != null) {
                nodeStack.push(curr);
                curr = curr.left;
            }

            curr = nodeStack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }

    public static List<Integer> mirrosInorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode curr = root;
        TreeNode pre = null;

        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return result;
    }

    public static List<List<Integer>> levelLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            List<Integer> levelResult = new ArrayList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = nodeQueue.poll();
                levelResult.add(treeNode.val);
                if (treeNode.left != null) {
                    nodeQueue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    nodeQueue.offer(treeNode.right);
                }
            }
            result.add(levelResult);
        }

        return result;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        boolean reverseFlag = false;
        while (!nodeQueue.isEmpty()) {
            List<Integer> levelResult = new ArrayList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = nodeQueue.poll();
                levelResult.add(treeNode.val);
                if (treeNode.left != null) {
                    nodeQueue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    nodeQueue.offer(treeNode.right);
                }
            }

            if (reverseFlag) {
                Collections.reverse(levelResult);
            }
            result.add(levelResult);

            reverseFlag = !reverseFlag;
        }

        return result;
    }

}
