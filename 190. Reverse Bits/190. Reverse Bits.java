/*
 * Problem: 190. Reverse Bits
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reverse-bits/
 * Language: java
 * Date: 2026-03-26
 */

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        int l = 32;
        while (n != 0) {
            res <<= 1;
            res += n & 1;
            n >>>= 1;
            l--;
        }
        return res << l;
    }
}
