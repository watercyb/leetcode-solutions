/*
 * Problem: 1430. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/
 * Language: java
 * Date: 2026-04-17
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int idx = -1;

    public boolean isValidSequence(TreeNode root, int[] arr) {
        idx++;
        if (idx < arr.length && root != null && root.val == arr[idx]) {
            if (idx == arr.length - 1 && root.left == null && root.right == null)
                return true;
            if (isValidSequence(root.left, arr))
                return true;
            if (isValidSequence(root.right, arr))
                return true;
        }
        idx--;
        return false;
    }
}
