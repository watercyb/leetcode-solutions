/*
 * Problem: 979. Distribute Coins in Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/distribute-coins-in-binary-tree/
 * Language: java
 * Date: 2026-04-10
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
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    int res = 0;

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        node.val += dfs(node.left) + dfs(node.right) - 1;
        res += Math.abs(node.val);
        return node.val;
    }
}
