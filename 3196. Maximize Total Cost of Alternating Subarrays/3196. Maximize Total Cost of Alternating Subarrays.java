/*
 * Problem: 3196. Maximize Total Cost of Alternating Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-total-cost-of-alternating-subarrays/?envType=problem-list-v2&envId=dynamic-programming
 * Language: java
 * Date: 2026-04-07
 */

class Solution {
    public long maximumTotalCost(int[] nums) {
        long a = 0;
        long b = Long.MIN_VALUE / 2;
        for (int num : nums) {
            long temp = a;
            a = b - num;
            b = Math.max(temp, b) + num;
        }
        return Math.max(a, b);
    }
}
