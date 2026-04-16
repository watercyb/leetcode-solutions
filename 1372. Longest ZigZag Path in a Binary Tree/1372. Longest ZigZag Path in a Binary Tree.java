/*
 * Problem: 1372. Longest ZigZag Path in a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
 * Language: java
 * Date: 2026-04-16
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
    public int longestZigZag(TreeNode root) {
        dfs(root, true);
        return max - 1;
    }

    int max = 0;

    public int dfs(TreeNode node, boolean left) {
        if (node == null)
            return 0;
        int l = dfs(node.left, true) + 1;
        int r = dfs(node.right, false) + 1;
        max = Math.max(Math.max(r, l), max);
        if (left)
            return r;
        return l;
    }
}
