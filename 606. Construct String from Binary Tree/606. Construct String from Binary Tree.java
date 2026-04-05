/*
 * Problem: 606. Construct String from Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/construct-string-from-binary-tree/
 * Language: java
 * Date: 2026-04-05
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
    public String tree2str(TreeNode root) {
        StringBuilder SB = new StringBuilder();
        build(root, SB);
        return SB.toString();
    }

    public void build(TreeNode node, StringBuilder SB) {
        SB.append(node.val);
        if (node.left == null && node.right == null)
            return;
        SB.append("(");
        if (node.left != null)
            build(node.left, SB);
        SB.append(")");
        if (node.right != null) {
            SB.append("(");
            build(node.right, SB);
            SB.append(")");
        }
    }
}
