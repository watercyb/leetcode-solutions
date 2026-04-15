/*
 * Problem: 1261. Find Elements in a Contaminated Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
 * Language: java
 * Date: 2026-04-15
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
class FindElements {
    BitSet BS = new BitSet(1<<20);

    public FindElements(TreeNode root) {
        dfs(root, 0);
    }

    public void dfs(TreeNode node, int x) {
        if (node == null)
            return;
        BS.set(x);
        dfs(node.left, 2 * x + 1);
        dfs(node.right, 2 * x + 2);
    }

    public boolean find(int target) {
        return BS.get(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
