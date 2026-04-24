/*
 * Problem: 2196. Create Binary Tree From Descriptions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/create-binary-tree-from-descriptions/
 * Language: java
 * Date: 2026-04-24
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
    public TreeNode createBinaryTree(int[][] descriptions) {
        int max = 0;
        for (int[] description : descriptions) {
            max = Math.max(Math.max(description[0], description[1]), max);
        }
        int[] counts = new int[max + 1];
        TreeNode[] nodes = new TreeNode[max + 1];
        for (int[] description : descriptions) {
            counts[description[0]]++;
            counts[description[1]] -= 2;
            if (nodes[description[0]] == null)
                nodes[description[0]] = new TreeNode(description[0]);
            if (nodes[description[1]] == null)
                nodes[description[1]] = new TreeNode(description[1]);
            if (description[2] == 1) {
                nodes[description[0]].left = nodes[description[1]];
            } else {
                nodes[description[0]].right = nodes[description[1]];
            }
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0)
                return nodes[i];
        }
        return null;
    }
}
