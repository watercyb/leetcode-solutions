/*
 * Problem: 314. Binary Tree Vertical Order Traversal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * Language: java
 * Date: 2026-04-01
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer>[] lists = new ArrayList[201];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        TreeNode[] arr = new TreeNode[101];
        int[] arr1 = new int[101];
        int l = 0;
        int r = 1;
        arr[0] = root;
        arr1[0] = 100;
        while (l < r) {
            TreeNode current = arr[l];
            int idx = arr1[l++];
            lists[idx].add(current.val);
            if (current.left != null) {
                arr[r] = current.left;
                arr1[r++] = idx - 1;
            }
            if (current.right != null) {
                arr[r] = current.right;
                arr1[r++] = idx + 1;
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> list : lists) {
            if (!list.isEmpty())
                res.add(list);
        }
        return res;
    }
}
