/*
 * Problem: 2220. Minimum Bit Flips to Convert Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int minBitFlips(int start, int goal) {
        int num = start ^ goal;
        int res = 0;
        while (num > 0) {
            res++;
            num -= num & -num;
        }
        return res;
    }
}
