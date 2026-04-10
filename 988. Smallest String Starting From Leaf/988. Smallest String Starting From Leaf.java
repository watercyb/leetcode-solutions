/*
 * Problem: 988. Smallest String Starting From Leaf
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/smallest-string-starting-from-leaf/
 * Language: java
 * Date: 2026-04-10
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
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new char[8500], 8499);
        return res;
    }

    String res = "~";

    public void dfs(TreeNode node, char[] chrs, int idx) {
        if (node == null)
            return;
        chrs[idx--] = (char) (node.val + 'a');
        if (node.left == null && node.right == null) {
            String str = new String(chrs, idx + 1, chrs.length - idx - 1);
            if (str.compareTo(res) < 0)
                res = str;
        } else {
            dfs(node.left, chrs, idx);
            dfs(node.right, chrs, idx);
        }
        idx++;
    }
}
