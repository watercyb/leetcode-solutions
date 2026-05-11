/*
 * Problem: 3831. Median of a Binary Search Tree Level
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/median-of-a-binary-search-tree-level/
 * Language: java
 * Date: 2026-05-11
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
    public int levelMedian(TreeNode root, int level) {
        dfs(root, 0, level);
        if (list.isEmpty())
            return -1;
        Collections.sort(list);
        return list.get(list.size() / 2);
    }

    List<Integer> list = new ArrayList<>();

    public void dfs(TreeNode node, int lv, int level) {
        if (node == null || lv > level)
            return;
        if (lv == level)
            list.add(node.val);
        dfs(node.left, lv + 1, level);
        dfs(node.right, lv + 1, level);
    }
}
