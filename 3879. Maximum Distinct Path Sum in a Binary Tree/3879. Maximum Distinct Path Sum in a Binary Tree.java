/*
 * Problem: 3879. Maximum Distinct Path Sum in a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-distinct-path-sum-in-a-binary-tree/
 * Language: java
 * Date: 2026-03-26
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
    public int maxSum(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        dfsLinks(root, -1, lists, values);
        int[][] links = new int[lists.size()][];
        int[] vals = new int[values.size()];
        for (int i = 0; i < links.length; i++) {
            List<Integer> list = lists.get(i);
            links[i] = new int[list.size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = list.get(j);
            }
            vals[i] = values.get(i);
        }
        int res = -100000000;
        boolean[] seens = new boolean[2001];
        for (int i = 0; i < links.length; i++) {
            res = Math.max(res, dfs(links, vals, seens, i, -1));
        }
        return res;
    }

    public int dfsLinks(TreeNode node, int prv, List<List<Integer>> links, List<Integer> values) {
        int currentIdx = links.size();
        List<Integer> arr = new ArrayList<>();
        links.add(arr);
        values.add(node.val);
        if (prv != -1)
            arr.add(prv);
        if (node.left != null)
            arr.add(dfsLinks(node.left, currentIdx, links, values));
        if (node.right != null)
            arr.add(dfsLinks(node.right, currentIdx, links, values));
        return currentIdx;
    }

    public int dfs(int[][] links, int[] values, boolean[] seens, int i, int prv) {
        int val = values[i];
        if (seens[val + 1000])
            return -100000000;
        seens[val + 1000] = true;
        int res = 0;
        for (int next : links[i]) {
            if (next != prv) {
                res = Math.max(res, dfs(links, values, seens, next, i));
            }
        }
        seens[val + 1000] = false;
        return Math.max(res, 0) + val;
    }
}
