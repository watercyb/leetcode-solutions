/*
 * Problem: 572. Subtree of Another Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/subtree-of-another-tree/
 * Language: java
 * Date: 2026-04-04
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;
        if (root.val == subRoot.val && dfs(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean dfs(TreeNode node, TreeNode target) {
        if (node == null && target == null)
            return true;
        if (node == null || target == null || node.val != target.val)
            return false;
        return dfs(node.left, target.left) && dfs(node.right, target.right);
    }
}
