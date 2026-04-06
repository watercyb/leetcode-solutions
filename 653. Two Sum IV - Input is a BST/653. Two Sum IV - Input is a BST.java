/*
 * Problem: 653. Two Sum IV - Input is a BST
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
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
    boolean[] seens = new boolean[20001];

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        int diff = k + 10000 - root.val;
        if (diff >= 0 && diff <= 20000 && seens[diff])
            return true;
        seens[root.val + 10000] = true;
        if (findTarget(root.left, k) || findTarget(root.right, k))
            return true;
        return false;
    }
}
