/*
 * Problem: 3352. Count K-Reducible Numbers Less Than N
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-k-reducible-numbers-less-than-n/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int countKReducibleNumbers(String s, int k) {
        int mod = 1_000_000_007;
        char[] chrs = s.toCharArray();
        int n = chrs.length;
        int[] steps = new int[n + 1];
        steps[0] = k;
        steps[1] = 1;
        for (int i = 2; i <= n; i++) {
            int idx = Integer.bitCount(i);
            steps[i] = steps[idx] + 1;
        }
        long[] DP = new long[n + 1];
        DP[0] = 1;
        int count = 1;
        for (int i = 1; i < chrs.length; i++) {
            for (int j = i; j >= 0; j--) {
                DP[j + 1] = (DP[j + 1] + DP[j]) % mod;
            }
            if (chrs[i] == '1') {
                DP[count]++;
                count++;
            }
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            if (steps[i] <= k) {
                res += DP[i];
            }
        }
        return (int) (res % mod);
    }
}
