/*
 * Problem: 987. Vertical Order Traversal of a Binary Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * Language: java
 * Date: 2026-04-10
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        Collections.sort(Li, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] != b[0] ? a[0] - b[0] : a[2] - b[2]);
        List<List<Integer>> res = new ArrayList<>();
        int prv = Integer.MIN_VALUE;
        List<Integer> tmp = new ArrayList<>();
        for (int[] arr : Li) {
            if (arr[1] != prv) {
                tmp = new ArrayList<>();
                res.add(tmp);
                prv = arr[1];
            }
            tmp.add(arr[2]);
        }
        return res;
    }

    List<int[]> Li = new ArrayList<>();

    public void dfs(TreeNode node, int row, int col) {
        if (node == null)
            return;
        Li.add(new int[] { row, col, node.val });
        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }
}
