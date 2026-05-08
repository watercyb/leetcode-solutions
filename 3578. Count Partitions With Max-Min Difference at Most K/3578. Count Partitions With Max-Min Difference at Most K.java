/*
 * Problem: 3578. Count Partitions With Max-Min Difference at Most K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-partitions-with-max-min-difference-at-most-k/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int countPartitions(int[] nums, int k) {
        int mod = 1_000_000_007;
        long[] sums = new long[nums.length + 2];
        sums[1] = 1;
        int[] MQ1 = new int[nums.length];
        int l1 = 0;
        int r1 = 0;
        int[] MQ2 = new int[nums.length];
        int l2 = 0;
        int r2 = 0;
        long res = 0;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            while (r1 > l1 && nums[i] >= nums[MQ1[r1 - 1]]) {
                r1--;
            }
            MQ1[r1++] = i;
            while (r2 > l2 && nums[i] <= nums[MQ2[r2 - 1]]) {
                r2--;
            }
            MQ2[r2++] = i;
            while (l1 < r1 && nums[MQ1[l1]] - nums[i] > k) {
                max = Math.max(MQ1[l1], max);
                l1++;
            }
            while (l2 < r2 && nums[i] - nums[MQ2[l2]] > k) {
                max = Math.max(MQ2[l2], max);
                l2++;
            }
            res = (sums[i + 1] - sums[max + 1] + mod) % mod;
            sums[i + 2] = (sums[i + 1] + res) % mod;
        }
        return (int) res;
    }
}
