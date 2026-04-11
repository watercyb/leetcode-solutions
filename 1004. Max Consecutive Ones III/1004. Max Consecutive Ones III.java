/*
 * Problem: 1004. Max Consecutive Ones III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/max-consecutive-ones-iii/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int longestOnes(int[] nums, int k) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            k += nums[i] - 1;
            if (k < 0) {
                k += 1 - nums[j];
                j++;
            }
        }
        return nums.length - j;
    }
}
