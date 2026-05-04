/*
 * Problem: 3157. Find the Level of Tree with Minimum Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-level-of-tree-with-minimum-sum/
 * Language: java
 * Date: 2026-05-04
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
    public int minimumLevel(TreeNode root) {
        int res = 0;
        long min = Long.MAX_VALUE;
        Deque<TreeNode> Dq = new ArrayDeque<>();
        Dq.addLast(root);
        int lv = 1;
        while (!Dq.isEmpty()) {
            int size = Dq.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = Dq.pollFirst();
                sum += current.val;
                if (current.left != null)
                    Dq.addLast(current.left);
                if (current.right != null)
                    Dq.addLast(current.right);
            }
            if (sum < min) {
                min = sum;
                res = lv;
            }
            lv++;
        }
        return res;
    }
}
