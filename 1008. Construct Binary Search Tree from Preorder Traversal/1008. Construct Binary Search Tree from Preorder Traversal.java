/*
 * Problem: 1008. Construct Binary Search Tree from Preorder Traversal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * Language: java
 * Date: 2026-04-11
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
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        TreeNode node = new TreeNode(preorder[idx++]);
        dfs(node, Integer.MAX_VALUE);
        return node;
    }

    int[] preorder;
    int idx = 0;

    public void dfs(TreeNode node, int lim) {
        if (idx < preorder.length && preorder[idx] < node.val) {
            node.left = new TreeNode(preorder[idx++]);
            dfs(node.left, node.val);
        }
        if (idx < preorder.length && preorder[idx] < lim) {
            node.right = new TreeNode(preorder[idx++]);
            dfs(node.right, lim);
        }
    }
}
