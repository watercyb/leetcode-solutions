/*
 * Problem: 2395. Find Subarrays With Equal Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-subarrays-with-equal-sum/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> HS = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            if (!HS.add(nums[i] + nums[i - 1]))
                return true;
        }
        return false;
    }
}
