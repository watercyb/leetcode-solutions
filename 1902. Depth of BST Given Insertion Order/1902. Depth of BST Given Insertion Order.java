/*
 * Problem: 1902. Depth of BST Given Insertion Order
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/depth-of-bst-given-insertion-order/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int maxDepthBST(int[] order) {
        int[] lefts = new int[order.length + 2];
        int[] rights = new int[order.length + 2];
        int[] heights = new int[order.length + 2];
        for (int i = 1; i <= order.length; i++) {
            lefts[i] = i + 1;
            rights[i] = i - 1;
        }
        for (int i = order.length - 1; i >= 0; i--) {
            int idx = order[i];
            int l = lefts[idx];
            int r = rights[idx];
            rights[l] = r;
            lefts[r] = l;
            heights[l] = Math.max(heights[idx] + 1, heights[l]);
            heights[r] = Math.max(heights[idx] + 1, heights[r]);
        }
        return heights[0];
    }
}
