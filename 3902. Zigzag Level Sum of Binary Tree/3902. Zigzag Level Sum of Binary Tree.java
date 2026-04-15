/*
 * Problem: 3902. Zigzag Level Sum of Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/zigzag-level-sum-of-binary-tree/
 * Language: java
 * Date: 2026-04-15
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
    public List<Long> zigzagLevelSum(TreeNode root) {
        int len = dfsLen(root);
        long[] sums = new long[len];
        dfsOdd(root, sums, new boolean[len], 0);
        dfsEven(root, sums, new boolean[len], 0);
        List<Long> res = new ArrayList<>();
        for (long sum : sums) {
            res.add(sum);
        }
        return res;
    }

    public int dfsLen(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(dfsLen(node.left), dfsLen(node.right)) + 1;
    }

    public void dfsOdd(TreeNode node, long[] sums, boolean[] blockeds, int lv) {
        if (node == null)
            return;
        if ((lv & 1) == 0) {
            if (node.left == null)
                blockeds[lv] = true;
            if (!blockeds[lv])
                sums[lv] += node.val;
        }
        dfsOdd(node.left, sums, blockeds, lv + 1);
        dfsOdd(node.right, sums, blockeds, lv + 1);
    }

    public void dfsEven(TreeNode node, long[] sums, boolean[] blockeds, int lv) {
        if (node == null)
            return;
        if ((lv & 1) == 1) {
            if (node.right == null)
                blockeds[lv] = true;
            if (!blockeds[lv])
                sums[lv] += node.val;
        }
        dfsEven(node.right, sums, blockeds, lv + 1);
        dfsEven(node.left, sums, blockeds, lv + 1);
    }
}
