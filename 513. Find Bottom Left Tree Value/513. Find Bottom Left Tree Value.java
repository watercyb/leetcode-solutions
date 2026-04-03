/*
 * Problem: 513. Find Bottom Left Tree Value
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-bottom-left-tree-value/
 * Language: java
 * Date: 2026-04-03
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
    public int findBottomLeftValue(TreeNode root) {
        res=new int[] { -1, -1 };
        dfs(root,0);
        return res[1];
    }

    int[] res = { -1,  -1 };

    public void dfs(TreeNode node,  int row) {
        if (node == null)
            return;
        if (row > res[0] )
            res = new int[] { row,  node.val };
        dfs(node.left,row+1);
        dfs(node.right,row+1);
    }
}
