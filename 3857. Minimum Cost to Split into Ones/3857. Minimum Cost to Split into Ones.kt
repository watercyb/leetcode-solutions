/*
 * Problem: 3857. Minimum Cost to Split into Ones
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-split-into-ones/
 * Language: kotlin
 * Date: 2026-05-11
 */

class Solution {
    fun minCost(n: Int): Int {
        return n*(n-1)/2;
    }
}
