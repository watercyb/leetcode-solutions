/*
 * Problem: 652. Find Duplicate Subtrees
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-duplicate-subtrees/
 * Language: java
 * Date: 2026-04-06
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
    public static List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
    public static HashMap<String,Integer> HM = new HashMap<String,Integer>();
        
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        treeNodeList.clear();
        HM.clear();
        scaner(root);
        return treeNodeList;

    }
    
    public static String scaner(TreeNode a) {
        if (a==null) {return "/";}
        String str = a.val + "," + scaner(a.left)+","+scaner(a.right);
        if (HM.containsKey(str)) {
            int n=HM.get(str)+1;
            HM.put(str, n);
            if (n==1) {treeNodeList.add(a);}
        } else {
            HM.put(str, 0);
        }
        return str;
    }

    
}
