/*
 * Problem: 1602. Find Nearest Right Node in Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/
 * Language: java
 * Date: 2026-04-19
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
    int lv = -1;
    int target = -1;

    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == null)
            return null;
        lv++;
        if (root == u) {
            target = lv;
        } else if (target == lv) {
            return root;
        } else {
            TreeNode res = findNearestRightNode(root.left, u);
            if (res != null)
                return res;
            res = findNearestRightNode(root.right, u);
            if (res != null)
                return res;
        }
        lv--;
        return null;
    }
}
