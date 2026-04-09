/*
 * Problem: 863. All Nodes Distance K in Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * Language: java
 * Date: 2026-04-09
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dist = k;
        if (k == 0) {
            res.add(target.val);
            return res;
        }
        dfs(root, target, k, false);
        return res;
    }

    List<Integer> res = new ArrayList<>();
    int dist;

    public int dfs(TreeNode node, TreeNode target, int k, boolean seen) {
        if (node == null)
            return -1;
        if (k == 0) {
            res.add(node.val);
            return -1;
        }
        if (node == target)
            seen = true;
        if (seen)
            k--;
        int l = dfs(node.left, target, k, seen);
        int r = dfs(node.right, target, k, seen);
        int n = Math.max(l, r);
        if (n == 0) {
            res.add(node.val);
        } else if (n > 0) {
            if (l > 0)
                dfs(node.right, target, n - 1, true);
            if (r > 0)
                dfs(node.left, target, n - 1, true);
        }
        if (node == target)
            return dist - 1;
        return n - 1;
    }
}
