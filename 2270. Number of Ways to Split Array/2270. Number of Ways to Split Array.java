/*
 * Problem: 2270. Number of Ways to Split Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-ways-to-split-array/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int res = 0;
        long sum1 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sum1 += nums[i];
            sum -= nums[i];
            if (sum1 >= sum)
                res++;
        }
        return res;
    }
}
