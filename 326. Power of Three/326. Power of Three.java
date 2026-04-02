/*
 * Problem: 326. Power of Three
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/power-of-three/
 * Language: java
 * Date: 2026-04-02
 */

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
