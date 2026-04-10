/*
 * Problem: 968. Binary Tree Cameras
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/binary-tree-cameras/
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
    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 2)
            res++;
        return res;
    }

    int res = 0;

    public int dfs(TreeNode node) {
        if (node == null)
            return 1;
        int l = dfs(node.left);
        int r = dfs(node.right);
        if (l == 2 || r == 2) {
            res++;
            return 0;
        }
        if (l == r) {
            return l + 1;
        } else {
            return 1;
        }
    }
}
