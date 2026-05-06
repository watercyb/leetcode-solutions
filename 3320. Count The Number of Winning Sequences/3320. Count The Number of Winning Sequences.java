/*
 * Problem: 3320. Count The Number of Winning Sequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-the-number-of-winning-sequences/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int countWinningSequences(String s) {
        char[] chrs = s.toCharArray();
        int length = chrs.length * 2 + 1;
        long[] DP1 = new long[length];
        long[] DP2 = new long[length];
        long[] DP3 = new long[length];
        DP1[chrs.length] = 1;
        DP2[chrs.length] = 1;
        DP3[chrs.length] = 1;
        long[] DPNext1 = new long[length];
        long[] DPNext2 = new long[length];
        long[] DPNext3 = new long[length];
        for (int i = 0; i < chrs.length; i++) {
            int idx = getIdx(chrs[i]);
            int l = chrs.length - i;
            int r = chrs.length + i;
            if (idx == 0) {
                for (int j = l; j <= r; j++) {
                    DPNext1[j] = (DP2[j] + DP3[j]) % mod;
                    DPNext2[j + 1] = (DP1[j] + DP3[j]) % mod;
                    DPNext3[j - 1] = (DP1[j] + DP2[j]) % mod;
                }
            } else if (idx == 1) {
                for (int j = l; j <= r; j++) {
                    DPNext1[j - 1] = (DP2[j] + DP3[j]) % mod;
                    DPNext2[j] = (DP1[j] + DP3[j]) % mod;
                    DPNext3[j + 1] = (DP1[j] + DP2[j]) % mod;
                }
            } else {
                for (int j = l; j <= r; j++) {
                    DPNext1[j + 1] = (DP2[j] + DP3[j]) % mod;
                    DPNext2[j - 1] = (DP1[j] + DP3[j]) % mod;
                    DPNext3[j] = (DP1[j] + DP2[j]) % mod;
                }
            }
            long[] DPTemp = DP1;
            DP1 = DPNext1;
            DPNext1 = DPTemp;
            DPTemp = DP2;
            DP2 = DPNext2;
            DPNext2 = DPTemp;
            DPTemp = DP3;
            DP3 = DPNext3;
            DPNext3 = DPTemp;
        }
        long res = 0;
        for (int i = chrs.length + 1; i < length; i++) {
            res = res + DP1[i] + DP2[i] + DP3[i];
        }
        return (int) (res % mod * reverce(2) % mod);
    }

    int mod = 1_000_000_007;

    public int getIdx(char chr) {
        switch (chr) {
            case 'F':
                return 0;
            case 'W':
                return 1;
            default:
                return 2;
        }
    }

    public long reverce(int a) {
        if (a == 1)
            return 1;
        return mod - (mod / a) * reverce(mod % a) % mod;
    }
}
