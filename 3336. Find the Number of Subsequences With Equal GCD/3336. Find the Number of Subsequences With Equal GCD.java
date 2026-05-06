/*
 * Problem: 3336. Find the Number of Subsequences With Equal GCD
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    static int[][] GCDs;

    public int subsequencePairCount(int[] nums) {
        int mod = 1_000_000_007;
        if (GCDs == null) {
            GCDs = new int[201][201];
            for (int i = 1; i < GCDs.length; i++) {
                GCDs[i][0] = GCDs[0][i] = i;
                for (int j = i; j < GCDs.length; j++) {
                    GCDs[i][j] = GCDs[j][i] = GCD(i, j);
                }
            }
        }
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        long[][] DP = new long[max + 1][max + 1];
        DP[0][0] = 1;
        for (int num : nums) {
            for (int i = 1; i <= max; i++) {
                for (int j = i; j <= max; j++) {
                    if (DP[i][j] == 0)
                        continue;
                    long count = DP[i][j];
                    int[] pair=getPair(i,GCDs[j][num]);
                    DP[pair[0]][pair[1]] = (DP[pair[0]][pair[1]] + count) % mod;
                    pair=getPair(GCDs[i][num],j);
                    DP[pair[0]][pair[1]] = (DP[pair[0]][pair[1]] + count) % mod;
                }
            }
            long[] arr = new long[max + 1];
            for (int i = 1; i <= max; i++) {
                arr[GCDs[i][num]] = (arr[GCDs[i][num]] + DP[0][i]) % mod;
            }
            for (int i = max; i >= 1; i--) {
                int[] pair=getPair(num,i);
                DP[pair[0]][pair[1]] = (DP[pair[0]][pair[1]] + DP[0][i]) % mod;
            }
            DP[0][num] += 2;
            for (int i = 1; i < arr.length; i++) {
                DP[0][i] += arr[i];
            }
        }
        long res = 0;
        for (int i = 1; i <= max; i++) {
            res += DP[i][i];
        }
        return (int) (res % mod);
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }

    public int[] getPair(int a,int b) {
        if (a<b) return new int[] {a,b};
        return new int[] {b,a};
    }
}
