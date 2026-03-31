/*
 * Problem: 298. Binary Tree Longest Consecutive Sequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 * Language: java
 * Date: 2026-03-31
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
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return res;
    }

    int res = 0;

    public int dfs(TreeNode node) {
        int max = 1;
        if (node.left != null) {
            int tmp = dfs(node.left);
            if (node.left.val == node.val + 1)
                max = tmp + 1;
        }
        if (node.right != null) {
            int tmp = dfs(node.right);
            if (node.right.val == node.val + 1)
                max = Math.max(tmp + 1, max);
        }
        res = Math.max(max, res);
        return max;
    }
}
