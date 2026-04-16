/*
 * Problem: 1305. All Elements in Two Binary Search Trees
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 * Language: java
 * Date: 2026-04-16
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1);
        List<Integer> res = new ArrayList<>();
        dfs(root2, res);
        while (idx < list.size()) {
            res.add(list.get(idx++));
        }
        return res;
    }

    List<Integer> list = new ArrayList<>();
    int idx = 0;

    public void dfs(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        dfs(node.left, res);
        while (idx < list.size() && node.val > list.get(idx)) {
            res.add(list.get(idx++));
        }
        res.add(node.val);
        dfs(node.right, res);
    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
}
