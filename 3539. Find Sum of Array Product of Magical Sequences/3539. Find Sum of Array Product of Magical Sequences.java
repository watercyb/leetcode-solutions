/*
 * Problem: 3539. Find Sum of Array Product of Magical Sequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-sum-of-array-product-of-magical-sequences/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int magicalSum(int M, int K, int[] nums) {
        if (C == null) {
            C = new long[31][31];
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j <= i / 2; j++) {
                    getC(i, j);
                }
            }
        }
        long[][][] DP = new long[M + 1][M][K + 1];
        DP[0][0][0] = 1;
        long[][] pros = new long[nums.length][M + 1];
        for (int i = 0; i < nums.length; i++) {
            long[][][] DPNext = new long[M + 1][M][K + 1];
            pros[i][0] = 1;
            for (int j = 1; j <= M; j++) {
                pros[i][j] = pros[i][j - 1] * nums[i] % mod;
            }
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k < M; k++) {
                    for (int l = 0; l <= K; l++) {
                        if (DP[j][k][l] > 0) {
                            for (int m = 0; m <= M - j; m++) {
                                int count = l + (k + m) % 2;
                                if (count > K)
                                    break;
                                DPNext[j + m][(k + m) >> 1][count] = (DPNext[j + m][(k + m) >> 1][count]
                                        + DP[j][k][l] * pros[i][m] % mod * C[j + m][m])
                                        % mod;
                            }
                        }
                    }
                }
            }
            DP = DPNext;
        }
        long res = 0;
        for (int i = 0; i < M; i++) {
            int count = Integer.bitCount(i);
            if (count <= K)
                res = (res + DP[M][i][K - count]) % mod;
        }
        return (int) res;
    }

    int mod = 1_000_000_007;
    static long[][] C;

    public long getC(int a, int b) {
        if (a - b < b)
            b = a - b;
        if (C[a][b] != 0)
            return C[a][b];
        int currentA = a;
        long res = 1;
        for (int i = 1; i <= b; i++) {
            res = res * a / i;
            a--;
        }
        return C[currentA][b] = C[currentA][currentA - b] = res % mod;
    }
}
