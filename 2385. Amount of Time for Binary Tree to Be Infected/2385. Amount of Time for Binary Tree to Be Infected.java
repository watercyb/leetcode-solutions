/*
 * Problem: 2385. Amount of Time for Binary Tree to Be Infected
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
 * Language: java
 * Date: 2026-04-26
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
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return max;
    }

    int max=0;

   public int dfs(TreeNode root, int start) {
        if (root.left==null&&root.right==null) {
            if (root.val==start)
                return -1;
            return 1;
        }
 
        int resLeft=0;
        int resRight=0;

        if (root.left!=null) resLeft=dfs(root.left,start);
        if (root.right!=null) resRight=dfs(root.right,start);

        if (root.val==start) {
            max=Math.max(resLeft,resRight);
            return -1;
        }
        if (resLeft>=0&&resRight>=0) {
            return Math.max(resLeft,resRight)+1;
        }
        int n=Math.min(resLeft,resRight);
        int p=Math.max(resLeft,resRight);
        max=Math.max(max,p-n);
        return --n;

    }

}
