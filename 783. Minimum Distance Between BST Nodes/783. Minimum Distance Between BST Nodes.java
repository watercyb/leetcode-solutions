/*
 * Problem: 783. Minimum Distance Between BST Nodes
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * Language: java
 * Date: 2026-04-08
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
    int prv = Integer.MIN_VALUE / 2;

    public int minDiffInBST(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;
        int res = minDiffInBST(root.left);
        res = Math.min(root.val - prv, res);
        prv = root.val;
        res = Math.min(minDiffInBST(root.right), res);
        return res;
    }
}
