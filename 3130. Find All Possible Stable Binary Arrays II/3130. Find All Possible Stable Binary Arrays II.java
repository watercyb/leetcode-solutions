/*
 * Problem: 3130. Find All Possible Stable Binary Arrays II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-all-possible-stable-binary-arrays-ii/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        long[][] DP1 = getCount(zero, limit);
        long[][] DP2 = getCount(one, limit);
        long res = 0;
        for (int i = 1; i <= Math.min(DP2.length - 1, zero); i++) {
            res = (res + DP1[i][zero] * (DP2[i][one] + DP2[i - 1][one])) % mod;
        }
        for (int i = 1; i <= Math.min(DP1.length - 1, one); i++) {
            res = (res + DP2[i][one] * (DP1[i][zero] + DP1[i - 1][zero])) % mod;
        }
        return (int) res;
    }

    int mod = 1_000_000_007;

    public long[][] getCount(int num, int lim) {
        long[][] res = new long[num + 2][num + 1];
        res[0][0] = 1;
        for (int i = 1; i <= num; i++) {
            int l = i - 1;
            int r = i;
            long sum = 0;
            while (r <= Math.min(lim * i, num)) {
                sum += res[i - 1][l];
                if (l > lim)
                    sum -= res[i - 1][l - lim];
                sum = (sum % mod + mod) % mod;
                res[i][r] = sum;
                l++;
                r++;
            }
        }
        return res;
    }
}
