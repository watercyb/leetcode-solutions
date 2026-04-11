/*
 * Problem: 1028. Recover a Tree From Preorder Traversal
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
 * Language: java
 * Date: 2026-04-11
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
    public TreeNode recoverFromPreorder(String traversal) {
        return dfs(traversal.toCharArray(), 0);
    }

    int idx = 0;
    int depth = 0;

    public TreeNode dfs(char[] chrs, int lv) {
        int val = 0;
        while (idx < chrs.length && chrs[idx] != '-') {
            val *= 10;
            val += chrs[idx] - '0';
            idx++;
        }
        TreeNode node = new TreeNode(val);
        depth = 0;
        if (idx == chrs.length)
            return node;
        while (chrs[idx] == '-') {
            depth++;
            idx++;
        }
        if (idx < chrs.length && depth > lv)
            node.left = dfs(chrs, lv + 1);
        if (idx < chrs.length && depth > lv)
            node.right = dfs(chrs, lv + 1);
        return node;
    }
}
