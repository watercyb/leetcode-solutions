/*
 * Problem: 156. Binary Tree Upside Down
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-tree-upside-down/
 * Language: java
 * Date: 2026-03-26
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null)
            return root;
        return dfs(root, null, null);
    }

    public TreeNode dfs(TreeNode node, TreeNode root, TreeNode right) {
        TreeNode l = node.left;
        TreeNode r = node.right;
        node.left = right;
        node.right = root;
        if (l == null)
            return node;
        else
            return dfs(l, node, r);
    }
}
