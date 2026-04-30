/*
 * Problem: 2799. Count Complete Subarrays in an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-complete-subarrays-in-an-array/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        boolean[] has = new boolean[2001];
        int count = 0;
        for (int num : nums) {
            if (!has[num]) {
                has[num] = true;
                count++;
            }
        }
        int[] counts = new int[2001];
        int j = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && count > 0) {
                if (has[nums[j]]) {
                    if (counts[nums[j]]++ == 0)
                        count--;
                }
                j++;
            }
            if (count > 0)
                break;
            res += nums.length - j + 1;
            if (has[nums[i]] && counts[nums[i]]-- == 1)
                count++;
        }
        return res;
    }
}
