/*
 * Problem: 2574. Left and Right Sum Differences
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/left-and-right-sum-differences/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int[] leftRightDifference(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int sum = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            total -= nums[i];
            res[i] = Math.abs(total - sum);
            sum += nums[i];
        }
        return res;
    }
}
