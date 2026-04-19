/*
 * Problem: 1644. Lowest Common Ancestor of a Binary Tree II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/
 * Language: java
 * Date: 2026-04-19
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    TreeNode res;

    public int dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return 0;
        int sum = 0;
        if (node == p || node == q)
            sum++;
        sum += dfs(node.left, p, q) + dfs(node.right, p, q);
        if (sum == 2) {
            res = node;
            sum = 0;
        }
        return sum;
    }
}
