/*
 * Problem: 124. Binary Tree Maximum Path Sum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
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
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    int res = Integer.MIN_VALUE;

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int l = dfs(node.left);
        int r = dfs(node.right);
        int sum = node.val;
        if (l > 0)
            sum += l;
        if (r > 0)
            sum += r;
        res = Math.max(sum, res);
        return Math.max(Math.max(Math.max(l, r), 0) + node.val, 0);
    }
}
