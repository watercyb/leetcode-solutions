/*
 * Problem: 637. Average of Levels in Binary Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/average-of-levels-in-binary-tree/
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
    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root, 0);
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) / counts.get(i));
        }
        return res;
    }

    List<Double> res = new ArrayList<>();
    List<Integer> counts = new ArrayList<>();

    public void dfs(TreeNode node, int lv) {
        if (node == null)
            return;
        if (lv == res.size()) {
            res.add((double) node.val);
            counts.add(1);
        } else {
            res.set(lv, res.get(lv) + (double) node.val);
            counts.set(lv, counts.get(lv) + 1);
        }
        dfs(node.left, lv + 1);
        dfs(node.right, lv + 1);
    }
}
