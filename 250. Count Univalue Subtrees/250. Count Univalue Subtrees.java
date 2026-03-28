/*
 * Problem: 250. Count Univalue Subtrees
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-univalue-subtrees/
 * Language: java
 * Date: 2026-03-28
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
    public int countUnivalSubtrees(TreeNode root) {
        if (root != null)
            dfs(root);
        return res;
    }

    int res = 0;

    public boolean dfs(TreeNode node) {
        boolean isUni = true;
        if (node.left != null)
            isUni &= dfs(node.left) && node.val == node.left.val;
        if (node.right != null)
            isUni &= dfs(node.right) && node.val == node.right.val;
        if (isUni)
            res++;
        return isUni;
    }
}
