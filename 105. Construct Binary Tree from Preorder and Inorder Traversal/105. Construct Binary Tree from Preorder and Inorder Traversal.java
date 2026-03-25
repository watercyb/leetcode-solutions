/*
 * Problem: 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, Integer.MAX_VALUE);
    }

    int i = 0;
    int j = 0;

    public TreeNode dfs(int[] preorder, int[] inorder, int lim) {
        if (inorder[j] == lim)
            return null;
        TreeNode node = new TreeNode(preorder[i]);
        if (++i == preorder.length)
            return node;
        if (node.val == inorder[j]) {
            j++;
            node.right = dfs(preorder, inorder, lim);
            return node;
        } else {
            node.left = dfs(preorder, inorder, node.val);
            j++;
            if (i < preorder.length)
                node.right = dfs(preorder, inorder, lim);
            return node;
        }
    }
}
