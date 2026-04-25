/*
 * Problem: 2265. Count Nodes Equal to Average of Subtree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 * Language: java
 * Date: 2026-04-25
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
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    int res = 0;

    public int[] dfs(TreeNode node) {
        if (node == null)
            return new int[] { 0, 0 };
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int[] sum = { l[0] + r[0]+node.val, l[1] + r[1]+1 };
        if (node.val == sum[0] / sum[1])
            res++;
        return sum;
    }
}
