/*
 * Problem: 3628. Maximum Number of Subsequences After One Inserting
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-subsequences-after-one-inserting/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long numOfSubsequences(String s) {
        char[] chrs = s.toCharArray();
        long[] ls = new long[chrs.length];
        long[] lcs = new long[chrs.length];
        long l = 0;
        long lc = 0;
        long sum = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == 'L') {
                l++;
            } else if (chrs[i] == 'C') {
                lc += l;
            } else if (chrs[i] == 'T') {
                sum += lc;
            }
            ls[i] = l;
            lcs[i] = lc;
        }
        long res = sum + lc;
        long t = 0;
        long ct = 0;
        for (int i = chrs.length - 1; i >= 1; i--) {
            if (chrs[i] == 'C') {
                ct += t;
            } else if (chrs[i] == 'T') {
                t++;
            }
            res = Math.max(sum + ls[i - 1] * t, res);
        }
        if (chrs[0] == 'C') {
            ct += t;
        }
        res = Math.max(sum + ct, res);
        return res;
    }
}
