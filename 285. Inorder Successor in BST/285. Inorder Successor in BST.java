/*
 * Problem: 285. Inorder Successor in BST
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/inorder-successor-in-bst/
 * Language: java
 * Date: 2026-03-31
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return root;
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else if (root.val > p.val) {
            TreeNode tmp = inorderSuccessor(root.left, p);
            if (tmp != null && root.val > tmp.val) {
                return tmp;
            } else {
                return root;
            }
        }
        return null;
    }
}
