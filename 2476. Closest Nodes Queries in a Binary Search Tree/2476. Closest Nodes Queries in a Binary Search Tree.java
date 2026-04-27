/*
 * Problem: 2476. Closest Nodes Queries in a Binary Search Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/
 * Language: java
 * Date: 2026-04-27
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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> Li = new ArrayList<>();
        dfs(Li, root);
        int[] arr = new int[Li.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Li.get(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int query : queries) {
            int idx = Arrays.binarySearch(arr, query);
            if (idx >= 0) {
                res.add(Arrays.asList(new Integer[] { query, query }));
            } else {
                idx = -idx - 1;
                if (idx == 0) {
                    res.add(Arrays.asList(new Integer[] { -1, arr[0] }));
                } else if (idx == Li.size()) {
                    res.add(Arrays.asList(new Integer[] { arr[arr.length-1], -1 }));
                } else {
                    res.add(Arrays.asList(new Integer[] { arr[idx-1], arr[idx] }));
                }
            }
        }
        return res;
    }

    public void dfs(List<Integer> Li, TreeNode node) {
        if (node == null)
            return;
        dfs(Li, node.left);
        Li.add(node.val);
        dfs(Li, node.right);
    }
}
