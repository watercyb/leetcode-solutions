/*
 * Problem: 671. Second Minimum Node In a Binary Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 * Language: java
 * Date: 2026-04-06
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
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    int res = -1;

    public void dfs(TreeNode node, int min) {
        if (node == null)
            return;
        if (node.val != min && (res == -1 || res > node.val))
            res = node.val;
        dfs(node.left, min);
        dfs(node.right, min);
    }
}
