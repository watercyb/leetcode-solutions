/*
 * Problem: 1676. Lowest Common Ancestor of a Binary Tree IV
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv/
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<TreeNode> HS = new HashSet<>();
        for (TreeNode node : nodes) {
            HS.add(node);
        }
        return dfs(root, HS);
    }

    public TreeNode dfs(TreeNode node, HashSet<TreeNode> HS) {
        if (node == null)
            return null;
        if (HS.contains(node))
            return node;
        TreeNode l = dfs(node.left, HS);
        TreeNode r = dfs(node.right, HS);
        if (l != null && r != null)
            return node;
        if (l != null)
            return l;
        return r;
    }
}
