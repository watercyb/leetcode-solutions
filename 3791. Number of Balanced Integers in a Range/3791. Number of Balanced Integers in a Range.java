/*
 * Problem: 3791. Number of Balanced Integers in a Range
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-balanced-integers-in-a-range/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long countBalanced(long low, long high) {
        long a = getCount(low - 1);
        long b = getCount(high);
        return b - a;
    }

    public long getCount(long num) {
        if (num == 0)
            return 0;
        char[] chrs = String.valueOf(num).toCharArray();
        int len = chrs.length * 10;
        long[] DP1 = new long[2 * len];
        long[] DP2 = new long[2 * len];
        int offset = len;
        int sign = 1;
        for (int i = 0; i < chrs.length; i++) {
            long[] DPNext1 = new long[2 * len];
            long[] DPNext2 = new long[2 * len];
            int digit = chrs[i] - '0';
            if (i == 0) {
                if (sign == 1) {
                    for (int j = 1; j < digit; j++) {
                        DPNext2[offset + j]++;
                    }
                } else {
                    for (int j = 1; j < digit; j++) {
                        DPNext1[offset - j]++;
                    }
                }
            } else {
                if (sign == 1) {
                    for (int j = 0; j < digit; j++) {
                        DPNext2[offset + j]++;
                    }
                } else {
                    for (int j = 0; j < digit; j++) {
                        DPNext1[offset - j]++;
                    }
                }
                for (int j = 1; j <= 9; j++) {
                    DPNext2[len + j]++;
                }
            }
            offset += sign * digit;
            sign = -sign;

            for (int k = 0; k < DP1.length; k++) {
                if (DP1[k] == 0)
                    continue;
                for (int j = 0; j <= Math.min(9, DP1.length - k - 1); j++) {
                    DPNext2[k + j] += DP1[k];
                }
            }
            for (int k = 0; k < DP2.length; k++) {
                if (DP2[k] == 0)
                    continue;
                for (int j = 0; j <= Math.min(9, k); j++) {
                    DPNext1[k - j] += DP2[k];
                }
            }
            DP1 = DPNext1;
            DP2 = DPNext2;
        }
        return DP1[len] + DP2[len] + (offset == len ? 1 : 0);
    }
}
