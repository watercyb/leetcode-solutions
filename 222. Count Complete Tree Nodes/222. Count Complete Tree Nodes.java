/*
 * Problem: 222. Count Complete Tree Nodes
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-complete-tree-nodes/
 * Language: java
 * Date: 2026-03-27
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
    int res = 0;

    public int countNodes(TreeNode root) {
        if (root == null)
            return res;
        res++;
        countNodes(root.left);
        countNodes(root.right);
        return res;
    }
}
