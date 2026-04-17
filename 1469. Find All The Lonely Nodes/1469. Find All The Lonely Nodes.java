/*
 * Problem: 1469. Find All The Lonely Nodes
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-all-the-lonely-nodes/
 * Language: java
 * Date: 2026-04-17
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
    List<Integer> res = new ArrayList<>();

    public List<Integer> getLonelyNodes(TreeNode root) {
        if (root != null) {
            if (root.left == null && root.right != null) {
                res.add(root.right.val);
                getLonelyNodes(root.right);
            } else if (root.left != null && root.right == null) {
                res.add(root.left.val);
                getLonelyNodes(root.left);
            } else {
                getLonelyNodes(root.right);
                getLonelyNodes(root.left);
            }
        }
        return res;
    }
}
