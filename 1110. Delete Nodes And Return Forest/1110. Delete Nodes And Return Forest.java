/*
 * Problem: 1110. Delete Nodes And Return Forest
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/delete-nodes-and-return-forest/
 * Language: java
 * Date: 2026-04-14
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        boolean[] isToDelete = new boolean[1001];
        for (int val : to_delete) {
            isToDelete[val] = true;
        }
        List<TreeNode> res = new ArrayList<>();
        TreeNode node = dfs(root, res, isToDelete);
        if (node != null)
            res.add(node);
        return res;
    }

    public TreeNode dfs(TreeNode node, List<TreeNode> res, boolean[] isToDelete) {
        if (node == null)
            return null;
        if (isToDelete[node.val]) {
            TreeNode l = dfs(node.left, res, isToDelete);
            if (l != null)
                res.add(l);
            TreeNode r = dfs(node.right, res, isToDelete);
            if (r != null)
                res.add(r);
            return null;
        } else {
            node.left = dfs(node.left, res, isToDelete);
            node.right = dfs(node.right, res, isToDelete);
            return node;
        }
    }
}
