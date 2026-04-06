/*
 * Problem: 643. Maximum Average Subarray I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-average-subarray-i/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(sum, max);
        }
        return (double) max / k;
    }
}
