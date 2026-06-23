/*
 * Problem: 3699. Number of ZigZag Arrays I
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-zigzag-arrays-i/?envType=daily-question&envId=2026-06-23
 * Language: java
 * Date: 2026-06-23
 */

class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int mod = 1_000_000_007;
        int len = r - l + 1;
        long[] DP = new long[len];
        Arrays.fill(DP, 1);
        for (int i = 0; i < n - 1; i++) {
            long[] DPNext = new long[len];
            long sum = 0;
            if (i % 2 == 0) {
                for (int j = len - 1; j >= 0; j--) {
                    DPNext[j] = sum;
                    sum = (sum + DP[j]) % mod;
                }
            } else {
                for (int j = 0; j < len; j++) {
                    DPNext[j] = sum;
                    sum = (sum + DP[j]) % mod;
                }
            }
            DP = DPNext;
        }
        long res = 0;
        for (long num : DP) {
            res += num;
        }
        return (int) (res * 2 % mod);
    }
}
