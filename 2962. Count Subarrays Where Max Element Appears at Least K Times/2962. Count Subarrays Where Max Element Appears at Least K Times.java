/*
 * Problem: 2962. Count Subarrays Where Max Element Appears at Least K Times
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int count = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max)
                count++;
            while (count >= k) {
                if (nums[j] == max)
                    count--;
                j++;
            }
            res += j;
        }
        return res;
    }
}
