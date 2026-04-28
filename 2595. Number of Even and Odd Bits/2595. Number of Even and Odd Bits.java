/*
 * Problem: 2595. Number of Even and Odd Bits
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-even-and-odd-bits/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int[] evenOddBit(int n) {
        int[] res = { 0, 0 };
        int idx = 0;
        while (n > 0) {
            res[idx] += n & 1;
            n >>= 1;
            idx = 1 - idx;
        }
        return res;
    }
}
