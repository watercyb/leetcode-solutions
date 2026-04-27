/*
 * Problem: 2484. Count Palindromic Subsequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-palindromic-subsequences/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int countPalindromes(String s) {
        int mod = 1_000_000_007;
        char[] chrs = s.toCharArray();
        long res = 0;
        int[][] arr = new int[chrs.length + 1][10];
        for (int i = 0; i < chrs.length; i++) {
            for (int j = 0; j <= 9; j++) {
                arr[i + 1][j] = arr[i][j];
            }
            arr[i + 1][chrs[i] - '0']++;
        }
        for (int i = 0; i <= 9; i++) {
            for (char j = '0'; j <= '9'; j++) {
                int[] counts = new int[chrs.length];
                int count = 0;
                for (int k = 0; k < chrs.length - 2; k++) {
                    if (chrs[k] == j) {
                        count += arr[k][i];
                    }
                    counts[k + 1] = count;
                }
                count = 0;
                for (int k = chrs.length - 1; k > 2; k--) {
                    if (chrs[k] == j) {
                        count += arr[chrs.length][i] - arr[k+1][i];
                    }
                    res += (long) counts[k - 1] * count;
                }
                res %= mod;
            }
        }
        return (int) res;
    }
}
