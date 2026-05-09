/*
 * Problem: 3654. Minimum Sum After Divisible Sum Deletions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-sum-after-divisible-sum-deletions/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long minArraySum(int[] nums, int k) {
        if (k == 1)
            return 0;
        long[] DP = new long[k];
        Arrays.fill(DP, Long.MAX_VALUE / 2);
        DP[0] = 0;
        long sum = 0;
        for (int num : nums) {
            sum += num;
            int mod = (int) (sum % k);
            sum = DP[mod] = Math.min(DP[mod], sum);
        }
        return sum;
    }
}
