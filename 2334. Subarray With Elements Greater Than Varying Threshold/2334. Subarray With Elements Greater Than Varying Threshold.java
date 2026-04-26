/*
 * Problem: 2334. Subarray With Elements Greater Than Varying Threshold
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/subarray-with-elements-greater-than-varying-threshold/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = threshold / nums[i] + 1;
        }
        int[] MQ = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            while (idx > 0 && nums[MQ[idx - 1]] <= nums[i]) {
                idx--;
            }
            MQ[idx++] = i;
            if (nums[i] <= i + 1) {
                if (idx == 1) {
                    return i + 1;
                } else {
                    int j = idx - 1;
                    while (j > 0 && nums[j] <= i + 1) {
                        if (i - nums[MQ[j]] >= MQ[j - 1])
                            return i - MQ[j - 1];
                        j--;
                    }
                    if (j == 0 && i + 1 - nums[MQ[0]] >= 0)
                        return i + 1;
                }
            }
        }
        return -1;
    }
}
