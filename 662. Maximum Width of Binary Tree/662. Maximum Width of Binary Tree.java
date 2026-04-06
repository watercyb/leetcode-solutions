/*
 * Problem: 662. Maximum Width of Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-width-of-binary-tree/
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
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0);
        return res + 1;
    }

    List<int[]> ranges = new ArrayList<>();
    int res = -1;

    public void dfs(TreeNode node, int n, int lv) {
        if (node == null)
            return;
        if (lv == ranges.size()) {
            ranges.add(new int[] { n, n });
            res = Math.max(0, res);
        } else {
            int[] range = ranges.get(lv);
            range[1] = n;
            res = Math.max(range[1] - range[0], res);
        }
        dfs(node.left, 2 * n + 1, lv + 1);
        dfs(node.right, 2 * n + 2, lv + 1);
    }
}
