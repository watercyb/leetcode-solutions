/*
 * Problem: 965. Univalued Binary Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/univalued-binary-tree/
 * Language: java
 * Date: 2026-04-10
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
    public boolean isUnivalTree(TreeNode root) {
        if (root.left == root.right)
            return true;
        if (root.left == null)
            return root.val == root.right.val && isUnivalTree(root.right);
        if (root.right == null)
            return root.val == root.left.val && isUnivalTree(root.left);
        return root.val == root.left.val && root.val == root.right.val && isUnivalTree(root.left)
                && isUnivalTree(root.right);
    }
}
