/*
 * Problem: 515. Find Largest Value in Each Tree Row
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 * Language: java
 * Date: 2026-04-03
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
    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    List<Integer> res = new ArrayList<>();

    public void dfs(TreeNode node, int n) {
        if (node == null)
            return;
        if (n == res.size()) {
            res.add(node.val);
        } else {
            res.set(n, Math.max(res.get(n), node.val));
        }
        dfs(node.left, n + 1);
        dfs(node.right, n + 1);
    }
}
