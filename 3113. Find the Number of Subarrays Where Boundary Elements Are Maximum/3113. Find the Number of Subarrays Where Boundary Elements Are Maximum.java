/*
 * Problem: 3113. Find the Number of Subarrays Where Boundary Elements Are Maximum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-number-of-subarrays-where-boundary-elements-are-maximum/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public long numberOfSubarrays(int[] nums) {
        int[] MQ = new int[nums.length];
        int[] counts = new int[nums.length];
        long res = 0;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            while (idx > 0 && MQ[idx - 1] < nums[i]) {
                idx--;
            }
            if (idx > 0 && MQ[idx - 1] == nums[i]) {
                counts[idx - 1]++;
            } else {
                counts[idx] = 1;
                MQ[idx++] = nums[i];
            }
            res += counts[idx - 1];
        }
        return res;
    }
}
