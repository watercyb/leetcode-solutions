/*
 * Problem: 1530. Number of Good Leaf Nodes Pairs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
 * Language: java
 * Date: 2026-04-18
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
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }

    int res = 0;

    public int[] dfs(TreeNode node, int k) {
        int[] counts = new int[k + 1];
        if (node.left == null && node.right == null) {
            counts[0] = 1;
        } else if (node.left == null) {
            int[] r = dfs(node.right, k);
            for (int i = 0; i < k; i++) {
                counts[i + 1] = r[i];
            }
        } else if (node.right == null) {
            int[] l = dfs(node.left, k);
            for (int i = 0; i < k; i++) {
                counts[i + 1] = l[i];
            }
        } else {
            int[] l = dfs(node.left, k);
            int[] r = dfs(node.right, k);
            for (int i = 0; i < k; i++) {
                counts[i + 1] = l[i];
                for (int j = 0; j < k - i - 1; j++) {
                    res += l[i] * r[j];
                }
            }
            for (int i = 0; i < k; i++) {
                counts[i + 1] += r[i];
            }
        }
        return counts;
    }
}
