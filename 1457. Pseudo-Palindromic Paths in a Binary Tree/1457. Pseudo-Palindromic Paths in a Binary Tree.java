/*
 * Problem: 1457. Pseudo-Palindromic Paths in a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
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
    public int pseudoPalindromicPaths(TreeNode root) {
        count = 0;
        int h = 0;
        dfs(h, root);
        return count;
    }

    int count;
    int[] code = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512 };

    public void dfs(int h, TreeNode root) {
        h ^= code[root.val];
        if (root.left != null)
            dfs(h, root.left);
        if (root.right != null)
            dfs(h, root.right);
        if (root.left == null && root.right == null) {
            if ((h&(h-1))==0) {
                count++;
                return;
            }
        }
        return;
    }
}
