/*
 * Problem: 3676. Count Bowl Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-bowl-subarrays/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long bowlSubarrays(int[] nums) {
        int[] MQ = new int[nums.length];
        int idx = 0;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (idx > 0 && nums[MQ[idx - 1]] < nums[i]) {
                if (i - MQ[idx - 1] >= 2)
                    res++;
                idx--;
            }
            if (idx > 0) {
                if (i - MQ[idx - 1] >= 2)
                    res++;
                if (nums[MQ[idx - 1]] == nums[i]) {
                    MQ[idx - 1] = i;
                } else {
                    MQ[idx++] = i;
                }
            } else {
                MQ[idx++] = i;
            }
        }
        return res;
    }
}
