/*
 * Problem: 333. Largest BST Subtree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/largest-bst-subtree/
 * Language: java
 * Date: 2026-04-03
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
    public int largestBSTSubtree(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return res;
    }

    int res = 0;

    public int[] dfs(TreeNode node) {
        int[] res = { node.val, node.val, 1 };
        if (node.left != null) {
            int[] tmp = dfs(node.left);
            if (tmp[1] >= node.val) {
                res[0] = Integer.MIN_VALUE / 2;
                res[1] = Integer.MAX_VALUE / 2;
                res[2] = Integer.MIN_VALUE;
            } else {
                res[0] = tmp[0];
                res[2] += tmp[2];
            }
        }
        if (node.right != null) {
            int[] tmp = dfs(node.right);
            if (tmp[0] <= node.val) {
                res[0] = Integer.MIN_VALUE / 2;
                res[1] = Integer.MAX_VALUE / 2;
                res[2] = Integer.MIN_VALUE;
            } else {
                res[1] = tmp[1];
                res[2] += tmp[2];
            }
        }
        this.res = Math.max(res[2], this.res);
        return res;
    }
}
