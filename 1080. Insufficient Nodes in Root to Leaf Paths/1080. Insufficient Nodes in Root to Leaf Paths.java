/*
 * Problem: 1080. Insufficient Nodes in Root to Leaf Paths
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
 * Language: java
 * Date: 2026-04-12
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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null) {
            if (root.val < limit)
                return null;
            return root;
        }
        TreeNode l = sufficientSubset(root.left, limit - root.val);
        TreeNode r = sufficientSubset(root.right, limit - root.val);
        if (l == null && r == null)
            return null;
        root.left = l;
        root.right = r;
        return root;
    }
}
