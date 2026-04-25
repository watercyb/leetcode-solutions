/*
 * Problem: 2281. Sum of Total Strength of Wizards
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sum-of-total-strength-of-wizards/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    int mod = 1_000_000_007;

    public int totalStrength(int[] strength) {
        long sum = 0;
        long[] sums = new long[strength.length + 1];
        for (int i = 0; i < strength.length; i++) {
            sum += strength[i];
            sums[i + 1] = (sums[i] + sum) % mod;
        }
        int[] MQ = new int[strength.length + 1];
        MQ[0] = -1;
        int idx = 1;
        long res = 0;
        for (int i = 0; i < strength.length; i++) {
            while (idx > 1 && strength[i] <= strength[MQ[idx - 1]]) {
                int a = MQ[idx - 2];
                int b = MQ[idx - 1];
                int c = i;
                long sumA = a == -1 ? 0 : sums[a];
                res = (res
                        + ((sums[c] - sums[b] + mod) * (b - a) % mod - (sums[b] - sumA + mod) * (c - b) % mod + mod)
                                * strength[MQ[idx - 1]])
                        % mod;
                idx--;
            }
            MQ[idx++] = i;
        }
        while (idx > 1) {
            int a = MQ[idx - 2];
            int b = MQ[idx - 1];
            int c = strength.length;
            long sumA = a == -1 ? 0 : sums[a];
            res = (res
                    + ((sums[c] - sums[b] + mod) * (b - a) % mod - (sums[b] - sumA + mod) * (c - b) % mod + mod)
                            * strength[MQ[idx - 1]])
                    % mod;
            idx--;
        }
        return (int) res;
    }
}
