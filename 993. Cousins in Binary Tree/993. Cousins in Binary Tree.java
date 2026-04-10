/*
 * Problem: 993. Cousins in Binary Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/cousins-in-binary-tree/
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
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, x, y, 0);
        return depth != -1;
    }

    int par = -1;
    int depth = -1;

    public boolean dfs(TreeNode node, int par, int x, int y, int n) {
        if (node == null)
            return false;
        if (node.val == x || node.val == y) {
            if (depth == -1) {
                depth = n;
                this.par = par;
            } else {
                if (depth != n || this.par == par)
                    depth = -1;
                return true;
            }
        }
        return dfs(node.left, node.val, x, y, n + 1) || dfs(node.right, node.val, x, y, n + 1);
    }
}
