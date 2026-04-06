/*
 * Problem: 693. Binary Number with Alternating Bits
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/binary-number-with-alternating-bits/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public boolean hasAlternatingBits(int n) {
        return n >> 1 == (n ^ ((1 << (32 - Integer.numberOfLeadingZeros(n))) - 1));
    }
}
