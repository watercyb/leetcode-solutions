/*
 * Problem: 663. Equal Tree Partition
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/equal-tree-partition/
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
    public boolean checkEqualTree(TreeNode root) {
        int sum = dfs(root);
        if ((sum & 1) == 1)
            return false;
        dfs(root.left, sum / 2);
        dfs(root.right, sum / 2);
        return res;
    }

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        return dfs(node.left) + dfs(node.right) + node.val;
    }

    boolean res = false;

    public int dfs(TreeNode node, int target) {
        if (node == null)
            return 0;
        int sum = dfs(node.left, target) + dfs(node.right, target) + node.val;
        if (sum == target)
            res = true;
        return sum;
    }
}
