/*
 * Problem: 2382. Maximum Segment Sum After Removals
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-segment-sum-after-removals/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int[] links = new int[nums.length];
        Arrays.fill(links, -1);
        long[] res = new long[removeQueries.length];
        long max = 0;
        for (int i = removeQueries.length - 1; i >= 0; i--) {
            res[i] = max;
            int l = removeQueries[i];
            int r = removeQueries[i];
            if (removeQueries[i] > 0 && links[removeQueries[i] - 1] >= 0)
                l = links[removeQueries[i] - 1];
            if (removeQueries[i] < nums.length - 1 && links[removeQueries[i] + 1] >= 0)
                r = links[removeQueries[i] + 1];
            links[l] = r;
            links[r] = l;
            max = Math.max(sums[r + 1] - sums[l], max);
        }
        return res;
    }
}
