/*
 * Problem: 95. Unique Binary Search Trees II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/unique-binary-search-trees-ii/
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
    public List<TreeNode> generateTrees(int n) {
        return getTrees(1,n);
        
    }
    
    public List<TreeNode> getTrees (int left, int right) {
        List<TreeNode> re=new ArrayList<>();
        if (left>right) {
            re.add(null);
            return re;
        }
        if (left==right){
            re.add(new TreeNode(left)); 
            return re;
        }
        
        for (int i=left;i<=right;i++) {
            List<TreeNode> leftNodes=getTrees(left, i-1);
            List<TreeNode> rightNodes=getTrees(i+1, right);
                for (TreeNode leftNode:leftNodes) {
                    for (TreeNode rightNode:rightNodes) {
                        re.add(new TreeNode(i,leftNode,rightNode));            
                    }
                }    
        }
        return re;
        
    }
}
