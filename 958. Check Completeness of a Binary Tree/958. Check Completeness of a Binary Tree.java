/*
 * Problem: 958. Check Completeness of a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/check-completeness-of-a-binary-tree/
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
    public boolean isCompleteTree(TreeNode root) {
        int depth = 0;
        TreeNode node = root;
        while (node.left != null) {
            depth++;
            node = node.left;
        }
        lim = depth;
        return dfs(root, 0);
    }

    int lim;
    boolean less = false;

    public boolean dfs(TreeNode node, int depth) {
        if (node == null) {
            if (depth - 1 == lim)
                return true;
            if (depth == lim) {
                if (less) {
                    return false;
                } else {
                    less = true;
                    lim--;
                    return true;
                }
            }
            return false;
        }
        return dfs(node.left, depth + 1) && dfs(node.right, depth + 1);
    }
}
