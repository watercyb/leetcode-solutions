/*
 * Problem: 2411. Smallest Subarrays With Maximum Bitwise OR
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int[] lefts = new int[31];
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            int max = i;
            for (int j = 0; j < lefts.length; j++) {
                if ((num & 1) == 1 && (lefts[j] == 0 || lefts[j] > i))
                    lefts[j] = i;
                max = Math.max(lefts[j], max);
                num >>= 1;
            }
            res[i] = max - i + 1;
        }
        return res;
    }
}
