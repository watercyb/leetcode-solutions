/*
 * Problem: 530. Minimum Absolute Difference in BST
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 * Language: java
 * Date: 2026-04-03
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

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;
        int res = getMinimumDifference(root.left);
        res = Math.min(root.val - prv, res);
        prv = root.val;
        res = Math.min(getMinimumDifference(root.right), res);
        return res;
    }
}
