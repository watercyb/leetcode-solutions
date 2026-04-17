/*
 * Problem: 1448. Count Good Nodes in Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * Language: java
 * Date: 2026-04-17
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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode node, int max) {
        if (node == null)
            return 0;
        if (node.val >= max) {
            return dfs(node.left, node.val) + dfs(node.right, node.val) + 1;
        }
        return dfs(node.left, max) + dfs(node.right, max);
    }
}
