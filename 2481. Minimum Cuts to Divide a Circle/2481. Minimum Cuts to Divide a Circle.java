/*
 * Problem: 2481. Minimum Cuts to Divide a Circle
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-cuts-to-divide-a-circle/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int numberOfCuts(int n) {
        if (n == 1)
            return 0;
        if (n % 2 == 0)
            return n / 2;
        return n;
    }
}
