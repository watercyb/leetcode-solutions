/*
 * Problem: 2313. Minimum Flips in Binary Tree to Get Result
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-flips-in-binary-tree-to-get-result/
 * Language: java
 * Date: 2026-04-26
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
    public int minimumFlips(TreeNode root, boolean result) {
        return dfs(root)[result ? 1 : 0];
    }

    public int[] dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            int[] res = { 1, 1 };
            res[node.val] = 0;
            return res;
        }
        int[] l = node.left != null ? dfs(node.left) : new int[] { 0, 0 };
        int[] r = node.right != null ? dfs(node.right) : new int[] { 0, 0 };
        switch (node.val) {
            case 2:
                return new int[] { l[0] + r[0], Math.min(Math.min(l[0] + r[1], l[1] + r[0]), l[1] + r[1]) };
            case 3:
                return new int[] { Math.min(Math.min(l[0] + r[1], l[1] + r[0]), l[0] + r[0]), l[1] + r[1] };
            case 4:
                return new int[] { Math.min(l[0] + r[0], l[1] + r[1]), Math.min(l[1] + r[0], l[0] + r[1]) };
            case 5:
                return new int[] { l[1] + r[1], l[0] + r[0] };
        }
        return new int[] { 0, 0 };
    }
}
