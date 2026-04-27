/*
 * Problem: 2458. Height of Binary Tree After Subtree Removal Queries
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/
 * Language: java
 * Date: 2026-04-27
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
    public int[] treeQueries(TreeNode root, int[] queries) {
        maxLengthes = new int[count(root, -1) + 1];
        dfsLeft(root, 0);
        max = 0;
        dfsRight(root, 0);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = maxLengthes[queries[i]];
        }
        return res;
    }

    public int count(TreeNode node, int lv) {
        if (node == null)
            return 0;
        return count(node.left, lv + 1) + count(node.right, lv + 1) + 1;
    }

    int[] maxLengthes;
    int max = 0;

    public void dfsRight(TreeNode node, int n) {
        maxLengthes[node.val] = Math.max(max, maxLengthes[node.val]);
        max = Math.max(n, max);
        if (node.right != null)
            dfsRight(node.right, n + 1);
        if (node.left != null)
            dfsRight(node.left, n + 1);
    }

    public void dfsLeft(TreeNode node, int n) {
        maxLengthes[node.val] = Math.max(max, n - 1);
        max = Math.max(n, max);
        if (node.left != null)
            dfsLeft(node.left, n + 1);
        if (node.right != null)
            dfsLeft(node.right, n + 1);
    }
}
