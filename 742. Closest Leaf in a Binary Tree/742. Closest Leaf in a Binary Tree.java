/*
 * Problem: 742. Closest Leaf in a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/closest-leaf-in-a-binary-tree/
 * Language: java
 * Date: 2026-04-08
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
    public int findClosestLeaf(TreeNode root, int k) {
        dfsBefore(root, k);
        return res;
    }

    int res = -1;
    int min = Integer.MAX_VALUE;

    public int[] dfsBefore(TreeNode node, int k) {
        if (node.left == null && node.right == null) {
            if (node.val == k) {
                res = k;
                min = 0;
            }
            return new int[] { 0, node.val };
        }
        if (node.val == k) {
            dfsAfter(node, 0);
            return new int[] { 0, node.val };
        }
        if (node.left != null && node.right != null) {
            int[] l = dfsBefore(node.left, k);
            int[] r = dfsBefore(node.right, k);
            if (l[1] == k) {
                if (l[0] + r[0] + 2 < min) {
                    min = l[0] + r[0] + 2;
                    res = r[1];
                }
                l[0]++;
                return l;
            } else if (r[1] == k) {
                if (l[0] + r[0] + 2 < min) {
                    min = l[0] + r[0] + 2;
                    res = l[1];
                }
                r[0]++;
                return r;
            } else if (l[0] < r[0]) {
                l[0]++;
                return l;
            } else {
                r[0]++;
                return r;
            }
        } else if (node.left != null) {
            int[] l = dfsBefore(node.left, k);
            l[0]++;
            return l;
        } else {
            int[] r = dfsBefore(node.right, k);
            r[0]++;
            return r;
        }
    }

    public void dfsAfter(TreeNode node, int n) {
        if (node.left == null && node.right == null && n < min) {
            res = node.val;
            min = n;
            return;
        }
        if (node.left != null)
            dfsAfter(node.left, n + 1);
        if (node.right != null)
            dfsAfter(node.right, n + 1);
    }
}
