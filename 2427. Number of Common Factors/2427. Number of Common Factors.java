/*
 * Problem: 2427. Number of Common Factors
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-common-factors/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int commonFactors(int a, int b) {
        int res = 0;
        for (int i = Math.min(a, b); i >= 1; i--) {
            if (a % i == 0 && b % i == 0)
                res++;
        }
        return res;
    }
}
