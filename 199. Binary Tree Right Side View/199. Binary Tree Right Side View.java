/*
 * Problem: 199. Binary Tree Right Side View
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-tree-right-side-view/
 * Language: java
 * Date: 2026-03-26
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        dfs(res,root,0);
        return res;
    }

    public void dfs( List<Integer> res, TreeNode node, int n) {
        if (node==null) return;
        if (n==res.size()) res.add(node.val);
        dfs(res,node.right,n+1);
        dfs(res,node.left,n+1);
    }
}
