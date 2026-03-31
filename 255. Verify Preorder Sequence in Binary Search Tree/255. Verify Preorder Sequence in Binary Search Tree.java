/*
 * Problem: 255. Verify Preorder Sequence in Binary Search Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int idx = 0;

    public boolean dfs(int[] preorder, int l, int r) {
        if (preorder[idx] < l)
            return false;
        if (preorder[idx] > r)
            return true;
        int current = preorder[idx++];
        if (idx < preorder.length && preorder[idx] < current && !dfs(preorder, l, current))
            return false;
        if (idx < preorder.length && preorder[idx] > current && !dfs(preorder, current, r))
            return false;
        if (idx == preorder.length || preorder[idx] != current)
            return true;
        return false;
    }
}
