/*
 * Problem: 2415. Reverse Odd Levels of Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/
 * Language: java
 * Date: 2026-04-27
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
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, true);
        return root;
    }

    List<List<Integer>> lists = new ArrayList<>();

    public void dfs(TreeNode left, TreeNode right, boolean odd) {
        if (left == null)
            return;
        if (odd) {
            int valTemp = left.val;
            left.val = right.val;
            right.val = valTemp;
        }
        odd = !odd;
        dfs(left.left, right.right, odd);
        dfs(left.right, right.left, odd);
    }
}
