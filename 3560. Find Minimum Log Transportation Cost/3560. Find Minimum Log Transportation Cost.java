/*
 * Problem: 3560. Find Minimum Log Transportation Cost
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-minimum-log-transportation-cost/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public long minCuttingCost(int n, int m, int k) {
        long res = 0;
        while (n > k) {
            res += (long) (n - k) * k;
            n -= k;
        }
        while (m > k) {
            res += (long) (m - k) * k;
            m -= k;
        }
        return res;
    }
}
