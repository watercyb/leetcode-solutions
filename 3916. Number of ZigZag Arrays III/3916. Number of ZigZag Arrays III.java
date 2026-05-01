/*
 * Problem: 3916. Number of ZigZag Arrays III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-zigzag-arrays-iii/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int zigZagArrays(int n, int l, int r) {
        if (r - l + 1 <= 100000)
            return getCount(n, r - l + 1);
        int[] x = new int[n + 1];
        int[] y = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            x[i] = i + 1;
            y[i] = getCount(n, i + 1);
        }
        return lagrange(x, y, r - l + 1);
    }

    int mod = 1_000_000_007;

    public int lagrange(int[] x, int[] y, int value) {
        long res = 0;
        for (int i = 0; i < x.length; i++) {
            long a = y[i];
            long b = 1;
            for (int j = 0; j < x.length; j++) {
                if (j != i) {
                    a = a * (value - x[j]) % mod;
                    b = b * (x[i] - x[j]) % mod;
                }
            }
            res += a * rev(b) % mod;
        }
        return (int) ((res % mod + mod) % mod);
    }

    public long rev(long a) {
        if (a == 1)
            return 1;
        return mod - mod / a * rev(mod % a) % mod;
    }

    public int getCount(int n, int m) {
        int[] DP = new int[m];
        Arrays.fill(DP, 1);
        for (int i = 1; i < n; i++) {
            int[] DPNext = new int[m];
            long sum = 0;
            if ((i & 1) == 0) {
                for (int j = 0; j < m; j++) {
                    DPNext[j] = (int) sum;
                    sum = (sum + DP[j]) % mod;
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    DPNext[j] = (int) sum;
                    sum = (sum + DP[j]) % mod;
                }
            }
            DP = DPNext;
        }
        long res = 0;
        for (int i = 0; i < m; i++) {
            res += DP[i];
        }
        return (int) (res * 2 % mod);
    }
}
