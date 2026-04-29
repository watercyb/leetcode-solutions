/*
 * Problem: 2689. Extract Kth Character From The Rope Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/extract-kth-character-from-the-rope-tree/
 * Language: java
 * Date: 2026-04-29
 */

/**
 * Definition for a rope tree node.
 * class RopeTreeNode {
 * int len;
 * String val;
 * RopeTreeNode left;
 * RopeTreeNode right;
 * RopeTreeNode() {}
 * RopeTreeNode(String val) {
 * this.len = 0;
 * this.val = val;
 * }
 * RopeTreeNode(int len) {
 * this.len = len;
 * this.val = "";
 * }
 * RopeTreeNode(int len, RopeTreeNode left, RopeTreeNode right) {
 * this.len = len;
 * this.val = "";
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public char getKthCharacter(RopeTreeNode root, int k) {
        if (!root.val.isEmpty())
            return root.val.charAt(k - 1);
        int count = root.left == null ? 0 : Math.max(root.left.len, root.left.val.length());
        if (count >= k) {
            return getKthCharacter(root.left, k);
        } else {
            return getKthCharacter(root.right, k - count);
        }
    }
}
