/*
 * Problem: 437. Path Sum III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/path-sum-iii/
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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> HM = new HashMap<>();
        HM.put(0l, 1);
        return dfs(root, HM, 0, targetSum);
    }

    public int dfs(TreeNode node, HashMap<Long, Integer> HM, long sum, int targetSum) {
        if (node == null)
            return 0;
        int res = 0;
        sum += node.val;
        res += HM.getOrDefault(sum - targetSum, 0);
        int count = HM.getOrDefault(sum, 0);
        HM.put(sum, count + 1);
        res += dfs(node.left, HM, sum, targetSum);
        res += dfs(node.right, HM, sum, targetSum);
        HM.put(sum, count);
        return res;
    }

}
