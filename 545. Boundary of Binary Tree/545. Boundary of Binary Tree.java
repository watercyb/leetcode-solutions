/*
 * Problem: 545. Boundary of Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/boundary-of-binary-tree/
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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        res.add(root.val);
        if (root.left != null)
            dfsLeft(root.left, true);
        if (root.right != null) {
            dfsRight(root.right, true);
        }
        return res;
    }

    List<Integer> res = new ArrayList<>();

    public void dfsLeft(TreeNode node, boolean left) {
        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }
        if (left)
            res.add(node.val);
        if (node.left == null) {
            dfsLeft(node.right, left);
        } else {
            dfsLeft(node.left, left);
            if (node.right != null)
                dfsLeft(node.right, false);
        }
    }

    public void dfsRight(TreeNode node, boolean right) {
        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }
        if (node.right == null) {
            dfsRight(node.left, right);
        } else {
            if (node.left != null)
                dfsRight(node.left, false);
            dfsRight(node.right, right);
        }
        if (right)
            res.add(node.val);
    }
}
