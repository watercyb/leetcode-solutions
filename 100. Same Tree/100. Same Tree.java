/*
 * Problem: 100. Same Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/same-tree/
 * Language: java
 * Date: 2026-03-25
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
    StringBuilder str =new StringBuilder();
    public boolean isSameTree(TreeNode p, TreeNode q) {
        getstr(p, "");
        String strP=str.toString();
        str =new StringBuilder();
        getstr(q, "");
        String strQ=str.toString();
        if (strP.equals(strQ)) {return true;}
        return false;
    }

    public void getstr(TreeNode t, String side) {
        if (t!=null) {
            getstr(t.left, "_l");
        }
        
        str.append(side);

        if (t!=null) {
            str.append(t.val);
        }

        if (t!=null) {
            getstr(t.right, "_r");
        }
    }
}
