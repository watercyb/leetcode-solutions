/*
 * Problem: 3010. Divide an Array Into Subarrays With Minimum Cost I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int minimumCost(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return nums[0] + min1 + min2;
    }
}
