/*
 * Problem: 501. Find Mode in Binary Search Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-mode-in-binary-search-tree/
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
    List<Integer> res = new ArrayList<>();
    int prv = Integer.MIN_VALUE;
    int count = 0;
    int max = 0;

    public int[] findMode(TreeNode root) {
        search(root);
        int[] ans=new int[res.size()];
        for (int i=0;i<ans.length;i++) {
            ans[i]=res.get(i);
        }
        return ans;
    }

    public void search(TreeNode node) {
        if (node == null)
            return;
        search(node.left);
        if (node.val != prv) {
            count = 1;
            prv = node.val;
        } else {
            count++;
        }
        if (count > max) {
            max = count;
            res.clear();
            res.add(prv);
        } else if (count == max) {
            res.add(prv);
        }
        search(node.right);
    }
}
