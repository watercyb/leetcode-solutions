/*
 * Problem: 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = inorder.length - 1;
        j = i;
        return dfs(inorder, postorder, Integer.MAX_VALUE);
    }

    int i;
    int j;

    public TreeNode dfs(int[] inorder, int[] postorder, int lim) {
        if (inorder[j] == lim)
            return null;
        TreeNode node = new TreeNode(postorder[i--]);
        if (i < 0)
            return node;
        if (node.val != inorder[j]) {
            node.right = dfs(inorder, postorder, node.val);
            if (i < 0)
                return node;
        }
        j--;
        node.left = dfs(inorder, postorder, lim);
        return node;
    }
}
