/*
 * Problem: 1318. Minimum Flips to Make a OR b Equal to c
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int minFlips(int a, int b, int c) {
        return Integer.bitCount((a | b) ^ c) + Integer.bitCount((a & b) & (~c));
    }
}
