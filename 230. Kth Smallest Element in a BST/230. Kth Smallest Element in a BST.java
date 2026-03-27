/*
 * Problem: 230. Kth Smallest Element in a BST
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Language: java
 * Date: 2026-03-27
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

    int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }

    public int dfs(TreeNode node) {
        if (node == null)
            return -1;
        int l = kthSmallest(node.left, k);
        if (l >= 0)
            return l;
        k--;
        if (k == 0)
            return node.val;
        int r = kthSmallest(node.right, k);
        if (r >= 0)
            return r;
        return -1;
    }
}
