/*
 * Problem: 2464. Minimum Subarrays in a Valid Split
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-subarrays-in-a-valid-split/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int validSubarraySplit(int[] nums) {
        int[] DP = new int[nums.length + 1];
        int max = Integer.MAX_VALUE / 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                DP[i + 1] = max;
            } else {
                int min = DP[i] + 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (min > DP[j] + 1 && GCD(nums[j], nums[i]) > 1)
                        min = DP[j] + 1;
                }
                DP[i + 1] = min;
            }
        }
        if (DP[DP.length - 1] >= max)
            return -1;
        return DP[DP.length - 1];
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
