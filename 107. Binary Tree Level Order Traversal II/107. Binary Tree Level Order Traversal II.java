/*
 * Problem: 107. Binary Tree Level Order Traversal II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * Language: java
 * Date: 2026-03-25
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        dfs(root, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = lists.size() - 1; i >= 0; i--) {
            res.add(lists.get(i));
        }
        return res;
    }

    List<List<Integer>> lists = new ArrayList<>();

    public void dfs(TreeNode node, int n) {
        if (node == null)
            return;
        if (n == lists.size()) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            lists.add(list);
        } else {
            lists.get(n).add(node.val);
        }
        dfs(node.left, n + 1);
        dfs(node.right, n + 1);
    }
}
