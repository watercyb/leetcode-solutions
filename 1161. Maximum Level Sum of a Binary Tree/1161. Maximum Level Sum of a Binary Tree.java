/*
 * Problem: 1161. Maximum Level Sum of a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
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
    public int maxLevelSum(TreeNode root) {
        dfs(root, 0);
        int res = 0;
        for (int i = 1; i <= lim; i++) {
            if (sums[i] > sums[res])
                res = i;
        }
        return res + 1;
    }

    int[] sums = new int[10001];
    int lim = 0;

    public void dfs(TreeNode node, int lv) {
        if (node == null)
            return;
        lim = Math.max(lv, lim);
        sums[lv] += node.val;
        dfs(node.left, lv + 1);
        dfs(node.right, lv + 1);
    }
}
