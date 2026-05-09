/*
 * Problem: 3689. Maximum Total Subarray Value I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-total-subarray-value-i/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return (long) (max - min) * k;
    }
}
