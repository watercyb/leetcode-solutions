/*
 * Problem: 889. Construct Binary Tree from Preorder and Postorder Traversal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * Language: java
 * Date: 2026-04-09
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

    int i = 0;
    int j = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode node = new TreeNode(preorder[i++]);
        if (node.val != postorder[j]) {
            node.left = constructFromPrePost(preorder, postorder);
            if (node.val != postorder[j])
                node.right = constructFromPrePost(preorder, postorder);
        }
        j++;
        return node;
    }
}
