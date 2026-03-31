/*
 * Problem: 257. Binary Tree Paths
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/binary-tree-paths/
 * Language: java
 * Date: 2026-03-31
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res, new StringBuilder());
        return res;
    }

    public void dfs(TreeNode node, List<String> res, StringBuilder SB) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            int size = SB.length();
            SB.append(String.valueOf(node.val));
            res.add(SB.toString());
            SB.setLength(size);
        } else {
            int size = SB.length();
            SB.append(String.valueOf(node.val)).append("->");
            dfs(node.left, res, SB);
            dfs(node.right, res, SB);
            SB.setLength(size);
        }
    }
}
