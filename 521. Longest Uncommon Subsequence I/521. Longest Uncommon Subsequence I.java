/*
 * Problem: 521. Longest Uncommon Subsequence I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/longest-uncommon-subsequence-i/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }
}
