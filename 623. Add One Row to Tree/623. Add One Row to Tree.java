/*
 * Problem: 623. Add One Row to Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/add-one-row-to-tree/
 * Language: java
 * Date: 2026-04-05
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode beginning = new TreeNode();
        beginning.left = root;
        dfs(beginning, val, depth);
        return beginning.left;
    }

    public void dfs(TreeNode node, int val, int depth) {
        if (node == null)
            return;
        if (depth == 1) {
            TreeNode left = new TreeNode(val);
            left.left = node.left;
            node.left = left;
            TreeNode right = new TreeNode(val);
            right.right = node.right;
            node.right = right;
        } else {
            dfs(node.left, val, depth - 1);
            dfs(node.right, val, depth - 1);
        }
    }
}
