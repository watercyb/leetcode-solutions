/*
 * Problem: 1991. Find the Middle Index in Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-middle-index-in-array/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left == sum - nums[i])
                return i;
            left += nums[i];
            sum -= nums[i];
        }
        return -1;
    }
}
