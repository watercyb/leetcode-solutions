/*
 * Problem: 4073. Count Good Strings
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-good-strings/
 * Language: java
 * Date: 2026-10-05
 */

class Solution {
    public int countGoodStrings(long n) {
        int mod = 1_000_000_007;
        long[][] matrix = { { 0, 1 }, { 1, 1 } };
        long[] arr = { 0, 2 };
        n--;
        while (n > 0) {
            if ((n & 1) == 1)
                arr = pro(arr, matrix, mod);
            matrix = pow(matrix, mod);
            n /= 2;
        }
        return (int) (arr[1] % mod);
    }

    public long[][] pow(long[][] a, int mod) {
        long[][] res = new long[a.length][a[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int k = 0; k < res.length; k++) {
                if (a[i][k] == 0)
                    continue;
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = (res[i][j] + a[i][k] * a[k][j]) % mod;
                }
            }
        }
        return res;
    }

    public long[] pro(long[] a, long[][] b, int mod) {
        long[] res = new long[a.length];
        for (int j = 0; j < res.length; j++) {
            if (a[j] == 0)
                continue;
            for (int i = 0; i < res.length; i++) {
                res[i] = (res[i] + a[j] * b[j][i]) % mod;
            }
        }
        return res;
    }
}
