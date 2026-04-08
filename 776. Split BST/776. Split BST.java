/*
 * Problem: 776. Split BST
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/split-bst/
 * Language: java
 * Date: 2026-04-08
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
    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null)
            return new TreeNode[2];
        if (root.val <= target) {
            TreeNode[] res = splitBST(root.right, target);
            root.right = res[0];
            res[0] = root;
            return res;
        } else {
            TreeNode[] res = splitBST(root.left, target);
            root.left = res[1];
            res[1] = root;
            return res;
        }
    }
}
