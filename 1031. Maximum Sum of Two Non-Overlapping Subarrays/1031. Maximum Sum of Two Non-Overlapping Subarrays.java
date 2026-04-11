/*
 * Problem: 1031. Maximum Sum of Two Non-Overlapping Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(getMax(nums, firstLen, secondLen), getMax(nums, secondLen, firstLen));
    }

    public int getMax(int[] nums, int a, int b) {
        int sumA = 0;
        for (int i = 0; i < a; i++) {
            sumA += nums[i];
        }
        int max = sumA;
        int sumB = 0;
        for (int i = a; i < a + b; i++) {
            sumB += nums[i];
        }
        int res = sumA + sumB;
        for (int i = a + b; i < nums.length; i++) {
            sumA += nums[i - b] - nums[i - a - b];
            sumB += nums[i] - nums[i - b];
            max = Math.max(max, sumA);
            res = Math.max(res, max + sumB);
        }
        return res;
    }
}
