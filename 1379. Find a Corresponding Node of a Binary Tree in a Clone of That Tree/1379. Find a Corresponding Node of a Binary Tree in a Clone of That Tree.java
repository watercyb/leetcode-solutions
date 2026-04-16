/*
 * Problem: 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 * Language: java
 * Date: 2026-04-16
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null)
            return null;
        if (original == target)
            return cloned;
        TreeNode node = getTargetCopy(original.left, cloned.left, target);
        if (node != null)
            return node;
        return getTargetCopy(original.right, cloned.right, target);
    }
}
