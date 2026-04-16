/*
 * Problem: 1315. Sum of Nodes with Even-Valued Grandparent
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
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
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, false, false);
    }

    public int dfs(TreeNode node, boolean p, boolean gp) {
        if (node == null)
            return 0;
        return (gp ? node.val : 0) + dfs(node.left, node.val % 2 == 0, p) + dfs(node.right, node.val % 2 == 0, p);
    }
}
