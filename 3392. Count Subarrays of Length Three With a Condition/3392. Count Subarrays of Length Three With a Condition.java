/*
 * Problem: 3392. Count Subarrays of Length Three With a Condition
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int countSubarrays(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if ((nums[i] + nums[i + 2]) * 2 == nums[i + 1])
                res++;
        }
        return res;
    }
}
