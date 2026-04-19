/*
 * Problem: 1612. Check If Two Expression Trees are Equivalent
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/check-if-two-expression-trees-are-equivalent/
 * Language: java
 * Date: 2026-04-19
 */

/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean checkEquivalence(Node root1, Node root2) {
        dfs(root1, 1);
        dfs(root2, -1);
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] != 0)
                return false;
        }
        return true;
    }

    int[] counts = new int['z' + 1];

    public void dfs(Node node, int n) {
        if (Character.isLetter(node.val)) {
            counts[node.val] += n;
        } else {
            dfs(node.left,n);
            dfs(node.right,n);
        }
    }
}
