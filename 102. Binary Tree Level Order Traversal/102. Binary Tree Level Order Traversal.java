/*
 * Problem: 102. Binary Tree Level Order Traversal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Language: java
 * Date: 2026-03-25
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root,0);
        return res;
    }

    List<List<Integer>> res=new ArrayList<>();

    public void dfs(TreeNode node, int level) {
        if (node==null) return;
        if (level==res.size()) res.add(new ArrayList<>());
        List<Integer> tmp=res.get(level);
        tmp.add(node.val);
        dfs(node.left,level+1);
        dfs(node.right, level+1);
    }

}
