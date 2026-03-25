/*
 * Problem: 113. Path Sum II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/path-sum-ii/
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return res;
        dfs(root, new ArrayList<>(), targetSum);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public void dfs(TreeNode node, List<Integer> list, int targetSum) {
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (targetSum - node.val == 0)
                res.add(new ArrayList<>(list));
        } else {
            if (node.left != null)
                dfs(node.left, list, targetSum - node.val);
            if (node.right != null)
                dfs(node.right, list, targetSum - node.val);
        }
        list.removeLast();

    }
}
