/*
 * Problem: 1145. Binary Tree Coloring Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-tree-coloring-game/
 * Language: java
 * Date: 2026-04-14
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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root, x, 0);
        return 2 * Math.max(Math.max(counts[0], counts[1]), counts[2]) > n;
    }

    int[] counts = new int[3];

    public void dfs(TreeNode node, int x, int pos) {
        if (node == null)
            return;
        if (node.val == x) {
            dfs(node.left, x, 1);
            dfs(node.right, x, 2);
        } else {
            counts[pos]++;
            dfs(node.left, x, pos);
            dfs(node.right, x, pos);
        }
    }
}
