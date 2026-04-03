/*
 * Problem: 331. Verify Preorder Serialization of a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        if (!dfs(strs))
            return false;
        return idx == strs.length - 1;
    }

    int idx = 0;

    public boolean dfs(String[] strs) {
        if (idx == strs.length)
            return false;
        if (strs[idx].equals("#"))
            return true;
        idx++;
        if (!dfs(strs))
            return false;
        idx++;
        if (idx == strs.length)
            return false;
        if (!dfs(strs))
            return false;
        return true;
    }
}
