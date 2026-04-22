/*
 * Problem: 1973. Count Nodes Equal to Sum of Descendants
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-nodes-equal-to-sum-of-descendants/
 * Language: java
 * Date: 2026-04-22
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int equalToDescendants(TreeNode root) {
        dfs(root);
        return res;
    }

    int res = 0;

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int sum = dfs(node.left) + dfs(node.right);
        if (sum == node.val)
            res++;
        return sum + node.val;
    }
}
