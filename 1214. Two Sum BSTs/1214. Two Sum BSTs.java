/*
 * Problem: 1214. Two Sum BSTs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/two-sum-bsts/
 * Language: java
 * Date: 2026-04-15
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
    List<Integer> list = new ArrayList<>();
    int idx = 0;

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        dfs1(root1);
        return dfs2(root2, target);
    }

    public void dfs1(TreeNode node) {
        if (node == null)
            return;
        dfs1(node.left);
        list.add(node.val);
        dfs1(node.right);
    }

    public boolean dfs2(TreeNode node, int target) {
        if (node == null)
            return false;
        if (dfs2(node.right, target))
            return true;
        while (idx < list.size() && list.get(idx) + node.val < target) {
            idx++;
        }
        if (idx == list.size())
            return false;
        if (list.get(idx) + node.val == target)
            return true;
        if (dfs2(node.left, target))
            return true;
        return false;
    }
}
