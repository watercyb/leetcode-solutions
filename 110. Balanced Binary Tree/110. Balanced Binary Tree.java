/*
 * Problem: 110. Balanced Binary Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/balanced-binary-tree/
 * Language: java
 * Date: 2026-03-25
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
    public boolean isBalanced(TreeNode root) {
        return dfs(root, 0) >= 0;
    }

    public int dfs(TreeNode node, int lv) {
        if (node == null)
            return lv;
        int l = dfs(node.left, lv + 1);
        if (l == -1)
            return -1;
        int r = dfs(node.right, lv + 1);
        if (r == -1)
            return -1;
        if (Math.abs(l - r) > 1)
            return -1;
        return Math.max(l, r);
    }
}
