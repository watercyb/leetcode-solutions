/*
 * Problem: 3958. Minimum Cost to Split into Ones II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-split-into-ones-ii/
 * Language: java
 * Date: 2026-06-09
 */

class Solution {
    public long minCost(int n) {
        return (long) n * (n - 1) / 2;
    }
}
