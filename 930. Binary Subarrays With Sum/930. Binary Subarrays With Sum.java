/*
 * Problem: 930. Binary Subarrays With Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-subarrays-with-sum/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return count(nums, goal) - count(nums, goal - 1);
    }

    public int count(int[] nums, int goal) {
        int res = 0;
        int j = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum > goal && j <=i) {
                sum -= nums[j++];
            }
            res += i - j + 1;
        }
        return res;
    }
}
