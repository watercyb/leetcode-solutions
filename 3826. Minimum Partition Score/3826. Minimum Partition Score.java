/*
 * Problem: 3826. Minimum Partition Score
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-partition-score/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public long minPartitionScore(int[] nums, int k) {
        DP = new long[nums.length + 1];
        DPNext = new long[nums.length + 1];
        sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        Arrays.fill(DP, max);
        DP[0] = 0;
        for (int i = 1; i <= k; i++) {
            DPNext[i - 1] = max;
            dfs(i, nums.length, i - 1, nums.length);
            long[] temp = DP;
            DP = DPNext;
            DPNext = temp;
        }
        return DP[nums.length];
    }

    long[] DP;
    long[] DPNext;
    long[] sums;
    long max = Long.MAX_VALUE / 2;

    public void dfs(int l, int r, int lLim, int rLim) {
        if (l > r)
            return;
        int mid = (l + r) >>> 1;
        long min = Long.MAX_VALUE / 2;
        int idx = 0;
        int lim = Math.min(rLim, mid);
        for (int i = lLim; i < lim; i++) {
            long sum = sums[mid] - sums[i];
            long score = DP[i] + sum * (sum + 1) / 2;
            if (score <= min) {
                min = score;
                idx = i;
            }
        }
        DPNext[mid] = min;
        dfs(l, mid - 1, lLim, idx + 1);
        dfs(mid + 1, r, idx, rLim);
    }
}
