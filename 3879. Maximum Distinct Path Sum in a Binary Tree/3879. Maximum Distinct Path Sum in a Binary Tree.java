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

    int idx = 0;

    public int maxSum(TreeNode root) {
        Map<Integer, List<Integer>> links = new HashMap<>();
        Map<Integer, Integer> values = new HashMap<>();

        dfsLinks(root, -1, links, values);

        int res = -100000000;

        for (int k : links.keySet()) {
            Set<Integer> seen = new HashSet<>();
            res = Math.max(res, dfs(links, values, seen, k, -1));
        }

        return res;
    }

    public int dfsLinks(TreeNode node, int prv,
            Map<Integer, List<Integer>> links,
            Map<Integer, Integer> values) {

        List<Integer> arr = new ArrayList<>();
        int currentIdx = idx++;

        if (prv != -1) {
            arr.add(prv);
        }

        if (node.left != null) {
            arr.add(dfsLinks(node.left, currentIdx, links, values));
        }

        if (node.right != null) {
            arr.add(dfsLinks(node.right, currentIdx, links, values));
        }

        links.put(currentIdx, arr);
        values.put(currentIdx, node.val);

        return currentIdx;
    }

    public int dfs(Map<Integer, List<Integer>> links,
            Map<Integer, Integer> values,
            Set<Integer> seen,
            int i, int prv) {

        int val = values.get(i);

        if (seen.contains(val)) {
            return -100000000;
        }

        seen.add(val);

        int res = 0;

        for (int next : links.get(i)) {
            if (next != prv) {
                res = Math.max(res, dfs(links, values, seen, next, i));
            }
        }

        seen.remove(val);

        return Math.max(res, 0) + val;
    }
}
