/*
 * Problem: 1302. Deepest Leaves Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/deepest-leaves-sum/
 * Language: java
 * Date: 2026-04-16
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
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    int res = 0;
    int max = 0;

    public void dfs(TreeNode node, int lv) {
        if (node == null)
            return;
        if (lv > max) {
            max = lv;
            res = node.val;
        } else if (lv == max) {
            res += node.val;
        }
        dfs(node.left, lv + 1);
        dfs(node.right, lv + 1);
    }
}
