/*
 * Problem: 536. Construct Binary Tree from String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/construct-binary-tree-from-string/
 * Language: java
 * Date: 2026-04-03
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
    public TreeNode str2tree(String s) {
        if (s.isEmpty())
            return null;
        return dfs(s.toCharArray());
    }

    int idx = 0;

    public TreeNode dfs(char[] chrs) {
        TreeNode node = new TreeNode();
        int num = 0;
        int p = 1;
        while (idx < chrs.length) {
            if (chrs[idx] == '-') {
                p = -1;
                idx++;
            } else if (Character.isDigit(chrs[idx])) {
                num *= 10;
                num += chrs[idx] - '0';
                idx++;
            } else if (chrs[idx] == '(') {
                idx++;
                if (node.left == null) {
                    node.left = dfs(chrs);
                } else {
                    node.right = dfs(chrs);
                }
            } else {
                idx++;
                node.val = num * p;
                return node;
            }
        }
        node.val = num * p;
        return node;
    }
}
