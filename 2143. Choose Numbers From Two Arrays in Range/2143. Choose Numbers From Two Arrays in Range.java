/*
 * Problem: 2143. Choose Numbers From Two Arrays in Range
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/choose-numbers-from-two-arrays-in-range/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int countSubranges(int[] nums1, int[] nums2) {
        int mod = 1_000_000_007;
        int sum1 = 0;
        for (int num : nums1) {
            sum1 += num;
        }
        int sum2 = 0;
        for (int num : nums2) {
            sum2 += num;
        }
        long[] DP = new long[sum1 + sum2 + 1];
        long res = 0;
        for (int i = 0; i < nums1.length; i++) {
            long[] DPNext = new long[DP.length];
            for (int j = 0; j < DP.length; j++) {
                if (DP[j] == 0)
                    continue;
                if (j + nums1[i] < DP.length)
                    DPNext[j + nums1[i]] = (DPNext[j + nums1[i]] + DP[j]) % mod;
                if (j - nums2[i] >= 0)
                    DPNext[j - nums2[i]] = (DPNext[j - nums2[i]] + DP[j]) % mod;
            }
            DPNext[nums1[i] + sum2]++;
            DPNext[sum2 - nums2[i]]++;
            DP = DPNext;
            res += DP[sum2];
        }
        return (int) (res % mod);
    }
}
