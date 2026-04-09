/*
 * Problem: 862. Shortest Subarray with Sum at Least K
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long[] sums = new long[nums.length + 1];
        int[] idx = new int[nums.length + 1];
        idx[0] = -1;
        int l = 0;
        int r = 1;
        long sum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (l < r && sum - sums[l] >= k) {
                res = Math.min(i - idx[l], res);
                l++;
            }
            while (r > l && sums[r - 1] >= sum) {
                r--;
            }
            sums[r] = sum;
            idx[r++] = i;
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }

}
