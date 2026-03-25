/*
 * Problem: 99. Recover Binary Search Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/recover-binary-search-tree/
 * Language: java
 * Date: 2026-03-25
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
    public void recoverTree(TreeNode root) {
        dfs(root);
        int tempVal = nodes[0].val;
        nodes[0].val = nodes[1].val;
        nodes[1].val = tempVal;
    }

    TreeNode prv = new TreeNode(Integer.MIN_VALUE);
    TreeNode[] nodes = new TreeNode[2];

    public void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        if (node.val < prv.val) {
            if (nodes[0] == null) {
                nodes[0] = prv;
                nodes[1] = node;
            } else {
                nodes[1] = node;
            }
        }        
        prv = node;
        dfs(node.right);
    }
}
