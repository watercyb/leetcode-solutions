/*
 * Problem: 938. Range Sum of BST
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/range-sum-of-bst/
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int res = 0;
        if (root.val < low) {
            if (root.right != null)
                res = rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            if (root.left != null)
                res = rangeSumBST(root.left, low, high);
        } else {
            res += root.val;
            if (root.right != null)
                res += rangeSumBST(root.right, low, high);
            if (root.left != null)
                res += rangeSumBST(root.left, low, high);
        }
        return res;
    }
}
