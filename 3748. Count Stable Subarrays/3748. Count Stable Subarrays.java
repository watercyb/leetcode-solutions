/*
 * Problem: 3748. Count Stable Subarrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-stable-subarrays/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long[] countStableSubarrays(int[] nums, int[][] queries) {
        int[] lefts = new int[nums.length];
        int count = 0;
        long[] sums = new long[nums.length + 1];
        sums[1] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                lefts[i] = ++count;
            } else {
                count = 0;
            }
            sums[i + 1] = sums[i] + lefts[i] + 1;
        }
        int[] rights = new int[nums.length];
        count = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                rights[i] = ++count;
            } else {
                count = 0;
            }
        }
        long[] res = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            res[i] = sums[r + 1] - sums[l] - lefts[l] * Math.min(rights[l], r - l) - lefts[l];
        }
        return res;
    }
}
