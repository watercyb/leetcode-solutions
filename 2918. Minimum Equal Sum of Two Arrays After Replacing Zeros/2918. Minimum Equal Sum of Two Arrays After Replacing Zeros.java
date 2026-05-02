/*
 * Problem: 2918. Minimum Equal Sum of Two Arrays After Replacing Zeros
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        boolean zero1 = false;
        boolean zero2 = false;
        for (int num : nums1) {
            if (num == 0) {
                sum1++;
                zero1 = true;
            } else {
                sum1 += num;
            }
        }
        for (int num : nums2) {
            if (num == 0) {
                sum2++;
                zero2 = true;
            } else {
                sum2 += num;
            }
        }
        if (sum1 == sum2 || (sum1 > sum2 && zero2))
            return sum1;
        if (sum1 < sum2 && zero1)
            return sum2;
        return -1;
    }
}
