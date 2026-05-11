/*
 * Problem: 3830. Longest Alternating Subarray After Removing At Most One Element
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-alternating-subarray-after-removing-at-most-one-element/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int longestAlternating(int[] nums) {
        int res = 1;
        int DP1 = 1;
        int DP2 = 1;
        int DP3 = 0;
        int DP4 = 0;
        int DP1Prv = 0;
        int DP2Prv = 0;
        for (int i = 1; i < nums.length; i++) {
            int DP1Next = 1;
            int DP2Next = 1;
            int DP3Next = 1;
            int DP4Next = 1;
            if (nums[i] > nums[i - 1]) {
                DP2Next = DP1 + 1;
            } else if (nums[i] < nums[i - 1]) {
                DP1Next = DP2 + 1;
            }
            if (i >= 2) {
                if (nums[i] > nums[i - 1]) {
                    DP4Next = DP3 + 1;
                } else if (nums[i] < nums[i - 1]) {
                    DP3Next = DP4 + 1;
                }
                if (nums[i] > nums[i - 2]) {
                    DP4Next = Math.max(DP4Next, DP1Prv + 1);
                } else if (nums[i] < nums[i - 1]) {
                    DP3Next = Math.max(DP3Next, DP2Prv + 1);
                }
            }
            DP1Prv = DP1;
            DP2Prv = DP2;
            DP1 = DP1Next;
            DP2 = DP2Next;
            DP3 = DP3Next;
            DP4 = DP4Next;
            res = Math.max(res, Math.max(Math.max(DP1, DP2), Math.max(DP3, DP4)));
        }
        return res;
    }
}
