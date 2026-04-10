/*
 * Problem: 918. Maximum Sum Circular Subarray
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-sum-circular-subarray/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sumMin = 0;
        int sumMax = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sumMin > 0)
                sumMin = 0;
            if (sumMax < 0)
                sumMax = 0;
            sumMin += num;
            sumMax += num;
            if (sumMin<min) min=sumMin;
            if (sumMax>max) max=sumMax;
        }
        if (min == sum)
            return max;
        return Math.max(max, sum - min);
    }
}
