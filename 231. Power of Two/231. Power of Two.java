/*
 * Problem: 231. Power of Two
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/power-of-two/
 * Language: java
 * Date: 2026-03-28
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}
