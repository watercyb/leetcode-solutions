/*
 * Problem: 3026. Maximum Good Subarray Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-good-subarray-sum/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Long> HM = new HashMap<>(nums.length, 0.99f);
        long res = Long.MIN_VALUE;
        long sum = 0;
        for (int num : nums) {
            HM.put(num, Math.min(HM.getOrDefault(num, Long.MAX_VALUE), sum));
            sum += num;
            res = Math.max(sum - HM.getOrDefault(num + k, Long.MAX_VALUE / 2), res);
            res = Math.max(sum - HM.getOrDefault(num - k, Long.MAX_VALUE / 2), res);
        }
        if (res < Long.MIN_VALUE / 3)
            return 0;
        return res;
    }
}
