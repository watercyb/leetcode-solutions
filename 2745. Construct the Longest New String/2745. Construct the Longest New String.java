/*
 * Problem: 2745. Construct the Longest New String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/construct-the-longest-new-string/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int longestString(int x, int y, int z) {
        int n = Math.min(x + 1, y);
        return (n + Math.min(n + 1, x) + z) * 2;
    }
}
