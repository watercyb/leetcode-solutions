/*
 * Problem: 1660. Correct a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/correct-a-binary-tree/
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
    public TreeNode correctBinaryTree(TreeNode root) {
        int target = dfs(root, Integer.MIN_VALUE, 0);
        dfs(root, target);
        return root;
    }

    public boolean dfs(TreeNode node, int target) {
        if (node.left != null) {
            if (node.left.val == target) {
                node.left = null;
                return true;
            } else {
                if (dfs(node.left, target))
                    return true;
            }
        }
        if (node.right != null) {
            if (node.right.val == target) {
                node.right = null;
                return true;
            } else {
                if (dfs(node.right, target))
                    return true;
            }
        }
        return false;
    }

    HashMap<Integer, int[]> HM = new HashMap<>();

    public int dfs(TreeNode node, int p, int lv) {
        if (node == null)
            return Integer.MIN_VALUE;
        if (HM.containsKey(node.val)) {
            int[] pair = HM.get(node.val);
            if (pair[1] > lv) {
                return pair[0];
            } else {
                return p;
            }
        } else {
            HM.put(node.val, new int[] { p, lv });
        }
        int l = dfs(node.left, node.val, lv + 1);
        if (l != Integer.MIN_VALUE)
            return l;
        int r = dfs(node.right, node.val, lv + 1);
        if (r != Integer.MIN_VALUE)
            return r;
        return Integer.MIN_VALUE;
    }
}
