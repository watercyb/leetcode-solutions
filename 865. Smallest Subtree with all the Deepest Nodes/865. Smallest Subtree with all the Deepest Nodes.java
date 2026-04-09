/*
 * Problem: 865. Smallest Subtree with all the Deepest Nodes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 * Language: java
 * Date: 2026-04-09
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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
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
