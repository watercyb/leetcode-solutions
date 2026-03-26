/*
 * Problem: 172. Factorial Trailing Zeroes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/factorial-trailing-zeroes/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
