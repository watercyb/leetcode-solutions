/*
 * Problem: 108. Convert Sorted Array to Binary Search Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sep(nums, 0, nums.length - 1);
    }

    public TreeNode sep(int[] nums, int l, int r) {
        if (l == r)
            return new TreeNode(nums[l]);
        int mid = (l + r) >>> 1;
        TreeNode node =new TreeNode(nums[mid]);
        if (l != mid)
            node.left = sep(nums, l, mid - 1);
        if (r != mid)
            node.right = sep(nums, mid + 1, r);
        return node;
    }
}
