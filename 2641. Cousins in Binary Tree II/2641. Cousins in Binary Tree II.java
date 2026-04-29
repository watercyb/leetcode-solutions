/*
 * Problem: 2641. Cousins in Binary Tree II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/cousins-in-binary-tree-ii/
 * Language: java
 * Date: 2026-04-29
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
    public TreeNode replaceValueInTree(TreeNode root) {
        dfs(root, 0);
        dfs(root, root.val, 0);
        return root;
    }

    int[] sums = new int[100001];

    public void dfs(TreeNode node, int n) {
        if (node == null)
            return;
        sums[n] += node.val;
        dfs(node.left, n + 1);
        dfs(node.right, n + 1);
    }

    public void dfs(TreeNode node, int sum, int n) {
        if (node == null)
            return;
        node.val = sums[n] - sum;
        sum = 0;
        if (node.left != null)
            sum += node.left.val;
        if (node.right != null)
            sum += node.right.val;
        dfs(node.left, sum, n + 1);
        dfs(node.right, sum, n + 1);
    }
}
