/*
 * Problem: 342. Power of Four
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/power-of-four/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean isPowerOfFour(int n) {
        return (n > 0 && n == (n & -n) && (n & 0xAAAAAAAA) == 0);
    }
}
