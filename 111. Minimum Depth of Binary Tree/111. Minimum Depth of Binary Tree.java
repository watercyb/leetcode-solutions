/*
 * Problem: 111. Minimum Depth of Binary Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Language: java
 * Date: 2026-03-25
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
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, 1);
        return res;
    }

    int res = Integer.MAX_VALUE;

    public void dfs(TreeNode node, int n) {
        if (n == res || node == null)
            return;
        if (node.left == null && node.right == null) {
            res = n;
        }
        dfs(node.left, n + 1);
        dfs(node.right, n + 1);
    }
}
