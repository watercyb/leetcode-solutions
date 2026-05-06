/*
 * Problem: 3319. K-th Largest Perfect Subtree Size in Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/k-th-largest-perfect-subtree-size-in-binary-tree/
 * Language: java
 * Date: 2026-05-06
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
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        dfs(root);
        for (int i = 10; i >= 0; i--) {
            if (counts[i] >= k)
                return (1 << i) - 1;
            k -= counts[i];
        }
        return -1;
    }

    int[] counts = new int[11];

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int l = dfs(node.left);
        int r = dfs(node.right);
        if (l == -1 || l != r)
            return -1;
        int res = l + 1;
        counts[res]++;
        return res;
    }
}
