/*
 * Problem: 1026. Maximum Difference Between Node and Ancestor
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 * Language: java
 * Date: 2026-04-11
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return max;

    }

    public int[] dfs(TreeNode root) {
        if (root.left == null && root.right == null)
            return new int[] { root.val, root.val };

        int[] left = { Integer.MAX_VALUE, Integer.MIN_VALUE };
        int[] right = { Integer.MAX_VALUE, Integer.MIN_VALUE };

        if (root.left != null)
            left = dfs(root.left);
        if (root.right != null)
            right = dfs(root.right);

        int minVal = Math.min(left[0], right[0]);
        int maxVal = Math.max(left[1], right[1]);
        if (root.val <= minVal) {
            max = Math.max(max, maxVal - root.val);
            minVal=root.val;
        } else if (root.val >= maxVal) {
            max = Math.max(max, root.val - minVal);
            maxVal=root.val;
        } else {
            max = Math.max(max, Math.max(maxVal - root.val, root.val - minVal));
        }

        return new int[] {minVal, maxVal};

    }
}
