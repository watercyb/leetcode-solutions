/*
 * Problem: 1123. Lowest Common Ancestor of Deepest Leaves
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 * Language: java
 * Date: 2026-04-14
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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    TreeNode res;
    int max = -1;

    public int dfs(TreeNode node, int depth) {
        if (node == null)
            return depth;
        int l = dfs(node.left, depth + 1);
        int r = dfs(node.right, depth + 1);
        if (l == r && l >= max) {
            res = node;
            max = l;
        }
        return Math.max(l, r);
    }
}
