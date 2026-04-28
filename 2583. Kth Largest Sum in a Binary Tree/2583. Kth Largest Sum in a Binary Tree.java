/*
 * Problem: 2583. Kth Largest Sum in a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/
 * Language: java
 * Date: 2026-04-28
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
    public long kthLargestLevelSum(TreeNode root, int k) {
        int count = dfs(root);
        if (k > count)
            return -1;
        sums = new long[count];
        dfs(root, 0);
        return sep(sums, 0, sums.length - 1, sums.length - k);
    }

    public long sep(long[] sums, int l, int r, int k) {
        long p = sums[l];
        swap(sums, l, r);
        int j = l;
        for (int i = l; i < r; i++) {
            if (sums[i] <= p) {
                swap(sums, i, j);
                j++;
            }
        }
        swap(sums, j, r);
        if (j < k) {
            return sep(sums, j + 1, r, k);
        } else if (j > k) {
            return sep(sums, l, j - 1, k);
        } else {
            return sums[j];
        }
    }

    public void swap(long[] sums, int i, int j) {
        long temp = sums[i];
        sums[i] = sums[j];
        sums[j] = temp;
    }

    long[] sums;
    int max = 0;

    public void dfs(TreeNode node, int n) {
        if (node == null)
            return;
        sums[n] += node.val;
        dfs(node.left, n + 1);
        dfs(node.right, n + 1);
    }

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(dfs(node.left), dfs(node.right)) + 1;
    }
}
