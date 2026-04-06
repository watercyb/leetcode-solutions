/*
 * Problem: 687. Longest Univalue Path
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-univalue-path/
 * Language: java
 * Date: 2026-04-06
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
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return res - 1;
    }

    int res = 0;

    public int dfs(TreeNode node) {
        int l = 0;
        int r = 0;
        if (node.left != null) {
            if (node.left.val == node.val) {
                l = dfs(node.left);
            } else {
                dfs(node.left);
            }
        }
        if (node.right != null) {
            if (node.right.val == node.val) {
                r = dfs(node.right);
            } else {
                dfs(node.right);
            }
        }
        res = Math.max(l + r + 1, res);
        return Math.max(l, r) + 1;
    }
}
