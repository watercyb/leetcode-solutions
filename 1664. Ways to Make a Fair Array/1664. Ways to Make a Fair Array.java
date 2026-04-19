/*
 * Problem: 1664. Ways to Make a Fair Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/ways-to-make-a-fair-array/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int waysToMakeFair(int[] nums) {
        int[] totals = new int[2];
        for (int i = 0; i < nums.length; i++) {
            totals[i & 1] += nums[i];
        }
        int res = 0;
        int total = totals[0] + totals[1];
        int[] sums = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int idx = i & 1;
            if ((idx == 1 && (sums[1] + totals[0] - sums[0]) * 2 == total - nums[i])
                    || (idx == 0 && (sums[0] + totals[1] - sums[1]) * 2 == total - nums[i]))
                res++;
            sums[idx] += nums[i];
        }
        return res;
    }
}
