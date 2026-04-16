/*
 * Problem: 1382. Balance a Binary Search Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/balance-a-binary-search-tree/
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
    public TreeNode balanceBST(TreeNode root) {
        dfs(root);
        return dfs1(list, 0, list.size() - 1);
    }

    List<Integer> list = new ArrayList<>();

    public TreeNode dfs1(List<Integer> list, int l, int r) {
        if (l > r)
            return null;
        if (l == r)
            return new TreeNode(list.get(l));
        int mid = (l + r) / 2;
        return new TreeNode(list.get(mid), dfs1(list, l, mid - 1), dfs1(list, mid + 1, r));
    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
}
