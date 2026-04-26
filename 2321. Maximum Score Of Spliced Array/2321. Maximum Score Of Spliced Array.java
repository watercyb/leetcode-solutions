/*
 * Problem: 2321. Maximum Score Of Spliced Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-score-of-spliced-array/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int max = 0;
        int min = 0;
        int sum1 = 0;
        int sum2 = 0;
        int max1 = 0;
        int min1 = 0;
        int sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
            sum += nums1[i] - nums2[i];
            max = Math.max(max, sum - min1);
            min = Math.min(min, sum - max1);
            if (sum > max1)
                max1 = sum;
            if (sum < min1)
                min1 = sum;
        }
        return Math.max(sum1 - min, sum2 + max);
    }
}
