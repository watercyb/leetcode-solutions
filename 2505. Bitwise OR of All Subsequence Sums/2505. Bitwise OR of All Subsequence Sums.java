/*
 * Problem: 2505. Bitwise OR of All Subsequence Sums
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/bitwise-or-of-all-subsequence-sums/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long subsequenceSumOr(int[] nums) {
        long res = 0;
        long sum = 0;
        for (int num : nums) {
            sum += num;
            res |= sum | num;
        }
        return res;
    }
}
