/*
 * Problem: 508. Most Frequent Subtree Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/most-frequent-subtree-sum/
 * Language: java
 * Date: 2026-04-03
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
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int[] res = new int[count];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : HM.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            if (v == max)
                res[idx++] = k;
        }
        return res;
    }

    HashMap<Integer, Integer> HM = new HashMap<>();
    int max = 0;
    int count = 0;

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int res = node.val + dfs(node.left) + dfs(node.right);
        int n = HM.getOrDefault(res, 0) + 1;
        if (n > max) {
            max = n;
            count = 1;
        } else if (n == max) {
            count++;
        }
        HM.put(res, n);
        return res;
    }
}
