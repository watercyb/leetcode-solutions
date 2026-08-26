/*
 * Problem: 1339. Maximum Product of Splitted Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 * Language: java
 * Date: 2026-08-26
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
    public int maxProduct(TreeNode root) {
        dfs(root, dfs(root));
        return (int) (max % 1_000_000_007);
    }

    long max = 0;

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        return dfs(node.left) + dfs(node.right) + node.val;
    }

    public long dfs(TreeNode node, int sum) {
        if (node == null)
            return 0;
        long tmp = dfs(node.left,sum) + dfs(node.right,sum) + node.val;
        max = Math.max((sum - tmp) * tmp, max);
        return tmp;
    }
}
