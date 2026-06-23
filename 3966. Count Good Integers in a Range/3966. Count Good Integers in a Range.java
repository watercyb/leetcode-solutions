/*
 * Problem: 3966. Count Good Integers in a Range
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-good-integers-in-a-range/
 * Language: java
 * Date: 2026-06-23
 */

class Solution {
    public long goodIntegers(long l, long r, int k) {
        if (k == 9)
            return r - l + 1;
        return get(r, k) - get(l - 1, k);
    }

    public long get(long num, int k) {
        char[] chrs = String.valueOf(num).toCharArray();
        long[] DP = new long[10];
        for (int i = 1; i < chrs[0] - '0'; i++) {
            DP[i] = 1;
        }
        boolean isGood = true;
        for (int i = 1; i < chrs.length; i++) {
            int idx = chrs[i] - '0';
            int prv = chrs[i - 1] - '0';
            long[] DPNext = new long[10];
            long sum = 0;
            for (int j = 0; j <= k; j++) {
                sum += DP[j];
            }
            for (int j = 0; j <= 9; j++) {
                DPNext[j] = sum;
                if (j + k + 1 <= 9)
                    sum += DP[j + k + 1];
                if (j - k >= 0)
                    sum -= DP[j - k];
            }
            if (isGood) {
                for (int j = 0; j < idx; j++) {
                    if (Math.abs(j - prv) <= k)
                        DPNext[j]++;
                }
                if (Math.abs(chrs[i] - chrs[i - 1]) > k)
                    isGood = false;
            }
            for (int j = 1; j <= 9; j++) {
                DPNext[j]++;
            }
            DP = DPNext;
        }
        long res = isGood ? 1 : 0;
        for (long n : DP) {
            res += n;
        }
        return res;
    }
}
