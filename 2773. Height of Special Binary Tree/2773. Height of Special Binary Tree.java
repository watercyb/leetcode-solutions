/*
 * Problem: 2773. Height of Special Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/height-of-special-binary-tree/
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
    public int heightOfTree(TreeNode root) {
        return dfs(root, 0);
    }

    int res = 0;

    public int dfs(TreeNode node, int n) {
        if (node == null)
            return 0;
        if (node.left == null || node.right == null || node.left.right != node)
            return Math.max(dfs(node.left, n + 1), dfs(node.right, n + 1));
        return n;
    }
}
