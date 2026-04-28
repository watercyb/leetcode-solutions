/*
 * Problem: 2547. Minimum Cost to Split an Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-to-split-an-array/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int minCost(int[] nums, int k) {
        if (k >= nums.length) {
            int len = 0;
            int[] counts = new int[1001];
            for (int i = 0; i < nums.length; i++) {
                if (counts[nums[i]] == 1) {
                    len += 2;
                } else if (counts[nums[i]] > 1) {
                    len++;
                }
                counts[nums[i]]++;
            }
            return len + k;
        }
        int[] DP = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int len = 0;
            int[] counts = new int[1001];
            int min = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                if (counts[nums[j]] == 1) {
                    len += 2;
                } else if (counts[nums[j]] > 1) {
                    len++;
                }
                counts[nums[j]]++;
                min = Math.min(DP[j] + len, min);
            }
            DP[i + 1] = min + k;
        }
        return DP[nums.length];
    }
}
