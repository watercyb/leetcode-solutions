/*
 * Problem: 3981. Count Distinct Ways to Form Target from Two Strings
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-distinct-ways-to-form-target-from-two-strings/
 * Language: java
 * Date: 2026-07-16
 */

class Solution {
    public int interleaveCharacters(String word1, String word2, String target) {
        if (target.length() == 1)
            return 0;
        char[] chrs1 = word1.toCharArray();
        char[] chrs2 = word2.toCharArray();
        char[] chrsT = target.toCharArray();
        long[][] DP = new long[chrs1.length + 1][chrs2.length + 1];
        DP[0][0] = 1;
        for (int k = 0; k < chrsT.length; k++) {
            long[][] DPNext = new long[chrs1.length + 1][chrs2.length + 1];
            for (int i = 0; i <= chrs1.length; i++) {
                long sum = 0;
                for (int j = 0; j < chrs2.length; j++) {
                    sum = (sum + DP[i][j]) % mod;
                    if (chrs2[j] == chrsT[k]) {
                        DPNext[i][j + 1] = sum;
                    }
                }
            }
            for (int i = 0; i <= chrs2.length; i++) {
                long sum = 0;
                for (int j = 0; j < chrs1.length; j++) {
                    sum = (sum + DP[j][i]) % mod;
                    if (chrs1[j] == chrsT[k]) {
                        DPNext[j + 1][i] += sum;
                    }
                }
            }
            DP = DPNext;
        }
        long res = 0;
        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < DP[0].length; j++) {
                res += DP[i][j];
            }
        }
        return (int) (((res - singleArr(chrs1, chrsT) - singleArr(chrs2, chrsT)) % mod + mod) % mod);
    }

    int mod = 1_000_000_007;

    public long singleArr(char[] chrs1, char[] chrs2) {
        long[] DP = new long[chrs1.length + 1];
        DP[0] = 1;
        for (int i = 0; i < chrs2.length; i++) {
            long sum = DP[0];
            for (int j = 0; j < chrs1.length; j++) {
                long temp = DP[j + 1];
                if (chrs2[i] == chrs1[j]) {
                    DP[j + 1] = sum;
                } else {
                    DP[j + 1] = 0;
                }
                sum = (sum + temp) % mod;
            }
            DP[0] = 0;
        }
        long res = 0;
        for (int i = 0; i < DP.length; i++) {
            res += DP[i];
        }
        return res;
    }
}
