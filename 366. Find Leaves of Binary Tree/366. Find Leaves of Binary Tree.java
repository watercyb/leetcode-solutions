/*
 * Problem: 366. Find Leaves of Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-leaves-of-binary-tree/
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int tmp = Math.max(dfs(node.left), dfs(node.right));
        if (tmp == res.size())
            res.add(new ArrayList<>());
        res.get(tmp).add(node.val);
        node.left = null;
        node.right = null;
        return tmp + 1;
    }
}
