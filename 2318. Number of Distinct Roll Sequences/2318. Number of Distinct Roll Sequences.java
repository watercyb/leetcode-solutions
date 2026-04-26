/*
 * Problem: 2318. Number of Distinct Roll Sequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-distinct-roll-sequences/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int distinctSequences(int n) {
        int[][] p = { { 1, 2, 3, 4, 5 }, { 0, 2, 4 }, { 0, 1, 3, 4 }, { 0, 2, 4 }, { 0, 1, 2, 3, 5 }, { 0, 4 } };
        int mod = 1_000_000_007;
        int[] DP = new int[36];
        for (int i = 0; i < 6; i++) {
            DP[i * 6 + i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            int[] DPNext = new int[36];
            for (int j = 0; j < 36; j++) {
                if (DP[j] == 0)
                    continue;
                int a = j / 6;
                int b = j % 6;
                for (int next : p[b]) {
                    if (next == a)
                        continue;
                    int c = b * 6 + next;
                    DPNext[c] = (DPNext[c] + DP[j]) % mod;
                }
            }
            DP = DPNext;
        }
        long res = 0;
        for (int i = 0; i < 36; i++) {
            res += DP[i];
        }
        return (int) (res % mod);
    }
}
