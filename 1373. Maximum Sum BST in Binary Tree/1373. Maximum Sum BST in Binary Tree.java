/*
 * Problem: 1373. Maximum Sum BST in Binary Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
 * Language: java
 * Date: 2026-04-16
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
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return max;
    }

    int max = 0;

    public int[] dfs(TreeNode node) {
        int[] res = { node.val, node.val, node.val };
        if (node.left != null) {
            int[] l = dfs(node.left);
            if (l[1] >= node.val) {
                res[0] = Integer.MIN_VALUE;
                res[1] = Integer.MAX_VALUE;
                //res[2] = Integer.MIN_VALUE;
            } else {
                res[0] = l[0];
                res[2] += l[2];
            }
        }
        if (res[0] == Integer.MIN_VALUE) {
            if (node.right != null)
                dfs(node.right);
        } else {
            if (node.right != null) {
                int[] r = dfs(node.right);
                if (r[0] <= node.val) {
                    res[0] = Integer.MIN_VALUE;
                    res[1] = Integer.MAX_VALUE;
                    //res[2] = Integer.MIN_VALUE;
                } else {
                    res[1] = r[1];
                    res[2] += r[2];
                    max = Math.max(res[2], max);
                }
            } else {
                max = Math.max(res[2], max);
            }
        }
        return res;
    }
}
