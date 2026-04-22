/*
 * Problem: 1977. Number of Ways to Separate Numbers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-ways-to-separate-numbers/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int numberOfCombinations(String num) {
        if (num.charAt(0) == '0')
            return 0;
        int mod = 1_000_000_007;
        char[] chrs = num.toCharArray();
        long[][] DP = new long[chrs.length][chrs.length + 1];
        for (int i = 0; i < chrs.length; i++) {
            int l = i - 1;
            while (l >= 0 && chrs[l] == chrs[i]) {
                l--;
            }
            for (int j = i; j >= 1; j--) {
                int length = i - j + 1;
                if (chrs[j] == '0') {
                    DP[i][length] = DP[i][length - 1];
                    continue;
                }
                int l1 = j;
                int l2 = j - 1;
                int l3 = 2 * j - i - 1;
                if (l3 < 0) {
                    DP[i][length] = (DP[l2][l2 + 1] + DP[i][length - 1]) % mod;
                } else if (l3 > l || chk(chrs, l3, l1)) {
                    DP[i][length] = (DP[l2][length] + DP[i][length - 1]) % mod;
                } else {
                    DP[i][length] = (DP[l2][length - 1] + DP[i][length - 1]) % mod;
                }
            }
            DP[i][i + 1] = DP[i][i] + 1;
        }
        return (int) DP[chrs.length - 1][chrs.length];
    }

    public boolean chk(char[] chrs, int i, int j) {
        int lim = j;
        while (i < lim) {
            if (chrs[i] < chrs[j])
                return true;
            if (chrs[i] > chrs[j])
                return false;
            i++;
            j++;
        }
        return true;
    }
}
