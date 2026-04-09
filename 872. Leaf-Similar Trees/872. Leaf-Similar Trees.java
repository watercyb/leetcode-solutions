/*
 * Problem: 872. Leaf-Similar Trees
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/leaf-similar-trees/
 * Language: java
 * Date: 2026-04-09
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
    StringBuilder SB;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        SB=new StringBuilder();
        dfs(root1);
        String str1=SB.toString();
        SB=new StringBuilder();
        dfs(root2);
        String str2=SB.toString();
        return str1.equals(str2);

    }

    public void dfs(TreeNode root) {
        if (root.left==null&&root.right==null) {
            SB.append(root.val);
            SB.append('#');
        }
        if (root.left!=null) dfs(root.left);
        if (root.right!=null) dfs(root.right);
    }
}
