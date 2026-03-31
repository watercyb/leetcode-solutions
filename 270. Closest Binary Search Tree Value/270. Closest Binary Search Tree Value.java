/*
 * Problem: 270. Closest Binary Search Tree Value
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/closest-binary-search-tree-value/
 * Language: java
 * Date: 2026-03-31
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
    int res = Integer.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        if (root == null)
            return res;
        double a = Math.abs((double) res - target);
        double b = Math.abs((double) root.val - target);
        if (a > b || (a == b && res > root.val))
            res = root.val;
        if (target < root.val)
            closestValue(root.left, target);
        if (target > root.val)
            closestValue(root.right, target);
        return res;
    }
}
