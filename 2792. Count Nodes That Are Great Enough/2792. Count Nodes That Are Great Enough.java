/*
 * Problem: 2792. Count Nodes That Are Great Enough
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-nodes-that-are-great-enough/
 * Language: java
 * Date: 2026-04-30
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int countGreatEnoughNodes(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    int res = 0;

    public Node dfs(TreeNode node, int k) {
        if (node == null)
            return new Node();
        Node left = dfs(node.left, k);
        Node right = dfs(node.right, k);
        Node newNode = new Node(left, right, node.val, k);
        if (newNode.isMoreThanK)
            res++;
        return newNode;
    }
}

class Node {
    int[] arr;
    boolean isMoreThanK = true;

    public Node() {
        arr = new int[0];
    }

    public Node(Node left, Node right, int val, int k) {
        arr = new int[Math.min(left.arr.length + right.arr.length + 1, k)];
        int i = 0;
        int j = 0;
        int idx = 0;
        while (idx < arr.length && i < left.arr.length && j < right.arr.length) {
            if (left.arr[i] >= val && right.arr[j] >= val) {
                isMoreThanK = false;
                arr[idx++] = val;
                val = Integer.MAX_VALUE;
            } else if (left.arr[i] < right.arr[j]) {
                arr[idx++] = left.arr[i++];
            } else {
                arr[idx++] = right.arr[j++];
            }
        }
        while (idx < arr.length && i < left.arr.length) {
            if (left.arr[i] >= val) {
                isMoreThanK = false;
                arr[idx++] = val;
                val = Integer.MAX_VALUE;
            } else {
                arr[idx++] = left.arr[i++];
            }
        }
        while (idx < arr.length && j < right.arr.length) {
            if (right.arr[j] >= val) {
                isMoreThanK = false;
                arr[idx++] = val;
                val = Integer.MAX_VALUE;
            } else {
                arr[idx++] = right.arr[j++];
            }
        }
        if (val != Integer.MAX_VALUE && idx < arr.length) {
            isMoreThanK = false;
            arr[idx] = val;
        }
    }
}
