/*
 * Problem: 272. Closest Binary Search Tree Value II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/closest-binary-search-tree-value-ii/
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        dfs(root, target, k);
        return res;
    }

    List<Integer> res = new LinkedList<>();

    public void dfs(TreeNode node, double target, int k) {
        if (node == null)
            return;
        dfs(node.left, target, k);
        if (res.size() < k) {
            res.add(node.val);
        } else {
            if (target - res.getFirst() > -target + node.val) {
                res.removeFirst();
                res.add(node.val);
            } else {
                return;
            }
        }
        dfs(node.right, target, k);
    }
}
