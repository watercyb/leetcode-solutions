/*
 * Problem: 450. Delete Node in a BST
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/delete-node-in-a-bst/
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            int next = remove(root);
            if (next == key) {
                return null;
            } else {
                deleteNode(root, next);
                root.val = next;
                return root;
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public int remove(TreeNode node) {
        if (node.left != null) {
            node = node.left;
            while (node.right != null) {
                node = node.right;
            }
        } else if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
        }
        return node.val;
    }
}
