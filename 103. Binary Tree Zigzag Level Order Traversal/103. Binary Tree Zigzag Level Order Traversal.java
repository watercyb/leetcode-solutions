/*
 * Problem: 103. Binary Tree Zigzag Level Order Traversal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Language: java
 * Date: 2026-03-25
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    List<List<Integer>> res;

    public void dfs(TreeNode root, int l) {
        if (root == null)
            return;
        if (res.size() == l)
            res.add(new ArrayList<>());
        if (l % 2 == 1) {
            res.get(l).add(0, root.val);
        } else {
            res.get(l).add(root.val);
        }
        dfs(root.left, l + 1);
        dfs(root.right, l + 1);
    }
}
