/*
 * Problem: 461. Hamming Distance
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/hamming-distance/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int xor = x ^ y;
        while (xor > 0) {
            res += 1 & xor;
            xor >>= 1;
        }
        return res;
    }
}
