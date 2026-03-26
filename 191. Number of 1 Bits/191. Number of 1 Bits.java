/*
 * Problem: 191. Number of 1 Bits
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-1-bits/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
