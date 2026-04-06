/*
 * Problem: 655. Print Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/print-binary-tree/
 * Language: java
 * Date: 2026-04-06
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
    public List<List<String>> printTree(TreeNode root) {
        int h = dfs(root);
        int w = (int) Math.pow(2, h);
        String[][] arr = new String[h][w - 1];
        dfs(root, arr, 0, w / 2 - 1, w / 4);
        List<List<String>> res = new ArrayList<>();
        for (String[] row : arr) {
            List<String> list = new ArrayList<>();
            for (String str : row) {
                if (str == null) {
                    list.add("");
                } else {
                    list.add(str);
                }
            }
            res.add(list);
        }
        return res;
    }

    public void dfs(TreeNode Node, String[][] arr, int i, int j, int l) {
        if (Node == null)
            return;
        arr[i][j] = String.valueOf(Node.val);
        dfs(Node.left, arr, i + 1, j - l, l / 2);
        dfs(Node.right, arr, i + 1, j + l, l / 2);
    }

    public int dfs(TreeNode Node) {
        if (Node == null)
            return 0;
        return Math.max(dfs(Node.left), dfs(Node.right)) + 1;
    }
}
