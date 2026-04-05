/*
 * Problem: 629. K Inverse Pairs Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/k-inverse-pairs-array/
 * Language: java
 * Date: 2026-04-05
 */

class Solution {
    public int kInversePairs(int n, int k) {
        int mod = 1_000_000_007;
        int[] DP = new int[k + 1];
        DP[0] = 1;
        int lim = 1;
        for (int i = 1; i < n; i++) {
            int[] DPNext = new int[k + 1];
            long sum = 0;
            for (int j = 0; j <= Math.min(k, lim); j++) {
                sum += DP[j];
                if (j > i)
                    sum -= DP[j - i - 1] - mod;
                sum %= mod;
                DPNext[j] = (int) sum;
            }
            lim += i + 1;
            DP = DPNext;
        }
        return DP[k];
    }
}
