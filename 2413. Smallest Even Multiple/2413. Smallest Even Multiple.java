/*
 * Problem: 2413. Smallest Even Multiple
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/smallest-even-multiple/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0)
            return n;
        return 2 * n;
    }
}
