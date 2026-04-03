/*
 * Problem: 337. House Robber III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/house-robber-iii/
 * Language: java
 * Date: 2026-04-03
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
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null)
            return new int[2];
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        return new int[] { Math.max(l[0], l[1]) + Math.max(r[0], r[1]), l[0] + r[0] + node.val };
    }
}
