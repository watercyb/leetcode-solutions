/*
 * Problem: 1063. Number of Valid Subarrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-valid-subarrays/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int validSubarrays(int[] nums) {
        int[] MQ = new int[nums.length];
        int idx = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (idx > 0 && MQ[idx - 1] > nums[i]) {
                idx--;
            }
            MQ[idx++] = nums[i];
            res += idx;
        }
        return res;
    }
}
