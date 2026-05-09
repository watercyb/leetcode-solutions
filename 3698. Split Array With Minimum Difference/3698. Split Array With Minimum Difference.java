/*
 * Problem: 3698. Split Array With Minimum Difference
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/split-array-with-minimum-difference/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long splitArray(int[] nums) {
        int idx = 0;
        long sum = 0;
        while (idx < nums.length - 1 && nums[idx] < nums[idx + 1]) {
            sum += nums[idx];
            idx++;
        }
        int mid = nums[idx];
        if (idx < nums.length - 1 && nums[idx] == nums[idx + 1]) {
            sum += nums[idx] - nums[idx + 1];
            mid = 0;
            idx++;
        }
        for (int i = idx + 1; i < nums.length; i++) {
            sum -= nums[i];
            if (nums[i - 1] <= nums[i])
                return -1;
        }
        return Math.min(Math.abs(sum - mid), Math.abs(sum + mid));
    }
}
