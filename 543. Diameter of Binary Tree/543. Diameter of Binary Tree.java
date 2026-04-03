/*
 * Problem: 543. Diameter of Binary Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/diameter-of-binary-tree/
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
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res-1;
    }

    int res = 0;

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int l = dfs(node.left);
        int r = dfs(node.right);
        res = Math.max(l + r + 1, res);
        return Math.max(l, r) + 1;
    }
}
