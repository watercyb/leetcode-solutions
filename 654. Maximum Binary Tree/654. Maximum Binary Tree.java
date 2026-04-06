/*
 * Problem: 654. Maximum Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-binary-tree/
 * Language: java
 * Date: 2026-04-06
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return sep(nums, 0, nums.length - 1);
    }

    public TreeNode sep(int[] nums, int l, int r) {
        if (l > r)
            return null;
        int max = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > nums[max])
                max = i;
        }
        return new TreeNode(nums[max],sep(nums, l, max-1),sep(nums, max+1, r));
    }
}
