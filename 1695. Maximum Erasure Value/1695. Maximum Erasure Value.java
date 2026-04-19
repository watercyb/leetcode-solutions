/*
 * Problem: 1695. Maximum Erasure Value
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-erasure-value/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] seens = new boolean[10001];
        int res = 0;
        int sum = 0;
        int j = 0;
        for (int i = 0; j < nums.length; i++) {
            while (j < nums.length && !seens[nums[j]]) {
                seens[nums[j]] = true;
                sum += nums[j++];
            }
            res = Math.max(sum, res);
            seens[nums[i]] = false;
            sum -= nums[i];
        }

        return res;
    }
}
