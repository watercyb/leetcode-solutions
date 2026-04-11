/*
 * Problem: 1038. Binary Search Tree to Greater Sum Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * Language: java
 * Date: 2026-04-11
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
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    int sum = 0;

    public void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.right);
        sum += node.val;
        node.val = sum;
        dfs(node.left);
    }
}
