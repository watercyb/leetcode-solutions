/*
 * Problem: 563. Binary Tree Tilt
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/binary-tree-tilt/
 * Language: java
 * Date: 2026-04-04
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
    public int findTilt(TreeNode root) {
        dfs(root);
        return res;
    }

    int res = 0;

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        res += Math.abs(left - right);
        return left + right + node.val;
    }
}
