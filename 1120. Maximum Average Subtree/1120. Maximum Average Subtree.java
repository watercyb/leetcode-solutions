/*
 * Problem: 1120. Maximum Average Subtree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-average-subtree/
 * Language: java
 * Date: 2026-04-14
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
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    double res = 0;

    public int[] dfs(TreeNode node) {
        if (node == null)
            return new int[] { 0, 0 };
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        l[0] += r[0] + node.val;
        l[1] += r[1] + 1;
        res = Math.max((double) l[0] / l[1], res);
        return l;
    }
}
