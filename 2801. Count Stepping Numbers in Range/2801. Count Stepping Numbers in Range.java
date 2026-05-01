/*
 * Problem: 2801. Count Stepping Numbers in Range
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-stepping-numbers-in-range/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int countSteppingNumbers(String low, String high) {
        int res = getCount(high, false) - getCount(low, true);
        if (res < 0)
            res += mod;
        return res;
    }

    int mod = 1_000_000_007;

    public int getCount(String str, boolean isLow) {
        long[] DP = new long[10];
        boolean lim = true;
        for (int i = '1'; i < str.charAt(0); i++) {
            DP[i - '0'] = 1;
        }
        char prv = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            long[] DPNext = new long[10];
            DPNext[1] = DP[0];
            DPNext[8] = DP[9];
            for (int j = 1; j < 9; j++) {
                DPNext[j - 1] += DP[j];
                DPNext[j + 1] += DP[j];
            }
            for (int j = 1; j <= 9; j++) {
                DPNext[j] = (DPNext[j] + 1) % mod;
            }
            DPNext[0] %= mod;
            if (lim) {
                char current = str.charAt(i);
                if (prv > '0' && prv <= current)
                    DPNext[prv - '1']++;
                if (prv < current - 1)
                    DPNext[prv - '0' + 1]++;
                if (Math.abs(prv - current) != 1) {
                    lim = false;
                } else {
                    prv = current;
                }
            }
            DP = DPNext;
        }
        long res = 0;
        for (long count : DP) {
            res += count;
        }
        if (lim && !isLow)
            res++;
        return (int) (res % mod);
    }
}
