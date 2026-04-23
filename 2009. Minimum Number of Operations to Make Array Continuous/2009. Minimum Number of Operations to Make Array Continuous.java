/*
 * Problem: 2009. Minimum Number of Operations to Make Array Continuous
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int j = 1;
        int max = 0;
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] <= nums[i] + nums.length - 1) {
                if (nums[j] == nums[j - 1])
                    count++;
                j++;
            }
            max = Math.max(j - i - count, max);
            if (j == nums.length) {
                return nums.length - max;
            }
            if (nums[i]==nums[i+1]) count--;
        }
        return nums.length - max;
    }
}
