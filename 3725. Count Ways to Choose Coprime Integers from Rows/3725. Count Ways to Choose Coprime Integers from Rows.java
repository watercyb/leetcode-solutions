/*
 * Problem: 3725. Count Ways to Choose Coprime Integers from Rows
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-ways-to-choose-coprime-integers-from-rows/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int countCoprime(int[][] mat) {
        int mod = 1_000_000_007;
        int max = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                max = Math.max(max, mat[i][j]);
            }
        }
        long[] counts = new long[max + 1];
        for (int i = max; i >= 2; i--) {
            long p = 1;
            for (int j = 0; j < mat.length && p > 0; j++) {
                int count = 0;
                for (int k = 0; k < mat[0].length; k++) {
                    if (mat[j][k] % i == 0)
                        count++;
                }
                p = (p * count) % mod;
            }
            for (int j = 2 * i; j <= max; j += i) {
                p -= counts[j];
            }
            counts[i] = (p % mod + mod) % mod;
        }
        long res = 1;
        long base = mat[0].length;
        int n = mat.length;
        while (n > 0) {
            if (n % 2 == 1)
                res = res * base % mod;
            base = base * base % mod;
            n /= 2;
        }
        for (int i = 2; i <= max; i++) {
            res -= counts[i];
        }
        return (int) ((res % mod + mod) % mod);
    }
}
