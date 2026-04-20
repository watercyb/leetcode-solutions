/*
 * Problem: 1740. Find Distance in a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-distance-in-a-binary-tree/
 * Language: java
 * Date: 2026-04-20
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
    public int findDistance(TreeNode root, int p, int q) {
        dfs(root, p, q, Integer.MIN_VALUE / 2);
        return res;
    }

    int res = 0;

    public int dfs(TreeNode node, int p, int q, int n) {
        if (node == null)
            return Integer.MIN_VALUE / 2;
        boolean seen = node.val == p || node.val == q;
        if (seen && n > 0) {
            res = n;
            return Integer.MIN_VALUE / 2;
        }
        if (seen)
            n = 0;
        int l = dfs(node.left, p, q, n + 1);
        int r = dfs(node.right, p, q, n + 1);
        if (l + r > 0) {
            res = l + r;
            return Integer.MIN_VALUE / 2;
        }
        if (seen)
            return 1;
        return Math.max(l, r) + 1;
    }
}
