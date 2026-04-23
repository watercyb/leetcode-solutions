/*
 * Problem: 2096. Step-By-Step Directions From a Binary Tree Node to Another
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
 * Language: java
 * Date: 2026-04-23
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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root, startValue, destValue);
        return before.append(after.reverse()).toString();
    }

    StringBuilder before = new StringBuilder();
    StringBuilder after = new StringBuilder();

    public int dfs(TreeNode node, int startValue, int destValue) {
        if (node == null)
            return 0;
        int l = dfs(node.left, startValue, destValue);
        if (l == 3)
            return 3;
        int r = dfs(node.right, startValue, destValue);
        if (r == 3)
            return 3;
        int res = 0;
        if (l == 1) {
            before.append('U');
            res = 1;
        } else if (l == 2) {
            after.append('L');
            res = 2;
        }
        if (r == 1) {
            before.append('U');
            res += 1;
        } else if (r == 2) {
            after.append('R');
            res += 2;
        }
        if (node.val == startValue) {
            res += 1;
        } else if (node.val == destValue) {
            res += 2;
        }
        return res;
    }
}
