/*
 * Problem: 2915. Length of the Longest Subsequence That Sums to Target
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] DP = new int[target + 1];
        Arrays.fill(DP, Integer.MIN_VALUE);
        DP[0] = 0;
        DP[target] = -1;
        for (int num : nums) {
            for (int i = target - num; i >= 0; i--) {
                DP[i + num] = Math.max(DP[i + num], DP[i] + 1);
            }
        }
        return DP[target];
    }
}
