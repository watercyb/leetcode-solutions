/*
 * Problem: 617. Merge Two Binary Trees
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/merge-two-binary-trees/
 * Language: java
 * Date: 2026-04-05
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        } else {
            root1.val += root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }
}
