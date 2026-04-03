/*
 * Problem: 549. Binary Tree Longest Consecutive Sequence II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/
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
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return res;
    }

    int res = 0;

    public int[] dfs(TreeNode node) {
        int[] max = { 1, 1 };
        if (node.left != null) {
            int[] tmp = dfs(node.left);
            if (node.left.val == node.val + 1) {
                max[0] = tmp[0] + 1;
            } else if (node.left.val == node.val - 1) {
                max[1] = tmp[1] + 1;
            }
        }
        if (node.right != null) {
            int[] tmp = dfs(node.right);
            if (node.right.val == node.val + 1) {
                max[0] = Math.max(tmp[0] + 1, max[0]);
            } else if (node.right.val == node.val - 1) {
                max[1] = Math.max(tmp[1] + 1, max[1]);
            }
        }
        res = Math.max(max[0] + max[1] - 1, res);
        return max;
    }
}
