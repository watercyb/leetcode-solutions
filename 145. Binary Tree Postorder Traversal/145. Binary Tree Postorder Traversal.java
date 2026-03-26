/*
 * Problem: 145. Binary Tree Postorder Traversal
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/binary-tree-postorder-traversal/
 * Language: java
 * Date: 2026-03-26
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> Dq = new ArrayDeque<>();
        Dq.offerLast(root);
        while (!Dq.isEmpty()) {
            TreeNode current = Dq.pollLast();
            if (current.left != null)
                Dq.offerLast(current.left);
            if (current.right != null)
                Dq.offerLast(current.right);
            res.add(current.val);
        }
        Collections.reverse(res);
        return res;
    }
}
