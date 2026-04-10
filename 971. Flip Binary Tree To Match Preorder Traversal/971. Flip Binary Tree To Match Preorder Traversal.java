/*
 * Problem: 971. Flip Binary Tree To Match Preorder Traversal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
 * Language: java
 * Date: 2026-04-10
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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (dfs(root, voyage) == 1 && idx == voyage.length)
            return res;
        return Arrays.asList(-1);
    }

    List<Integer> res = new ArrayList<>();
    int idx = 0;

    public int dfs(TreeNode node, int[] voyage) {
        if (idx == voyage.length || node == null)
            return 1;
        if (node.val != voyage[idx])
            return 0;
        idx++;
        int type = dfs(node.left, voyage);
        if (type == -1)
            return -1;
        if (type == 0) {
            res.add(node.val);
            if (dfs(node.right, voyage) != 1 || dfs(node.left, voyage) != 1)
                return -1;
        } else if (dfs(node.right, voyage) != 1) {
            return -1;
        }
        return 1;
    }
}
