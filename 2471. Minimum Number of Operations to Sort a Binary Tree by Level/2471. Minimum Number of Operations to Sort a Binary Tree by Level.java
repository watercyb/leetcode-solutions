/*
 * Problem: 2471. Minimum Number of Operations to Sort a Binary Tree by Level
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/
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
    public int minimumOperations(TreeNode root) {
        dfs(root, 0);
        int res = 0;
        for (List<Long> list : lists) {
            res += count(list);
        }
        return res;
    }

    List<List<Long>> lists = new ArrayList<>();

    public int count(List<Long> list) {
        if (list.size() == 1)
            return 0;
        long[] arr = new long[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] &= 0xFFFFF;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                int idx = (int) arr[i];
                arr[i] = arr[idx];
                arr[idx] = idx;
                res++;
            }
        }
        return res;
    }

    public void dfs(TreeNode node, int n) {
        if (node == null)
            return;
        if (n == lists.size())
            lists.add(new ArrayList<>());
        List<Long> list = lists.get(n);
        list.add(((long) node.val << 20) + list.size());
        dfs(node.left, n + 1);
        dfs(node.right, n + 1);
    }
}
