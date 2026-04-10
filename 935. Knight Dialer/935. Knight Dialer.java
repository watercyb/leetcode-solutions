/*
 * Problem: 935. Knight Dialer
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/knight-dialer/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int knightDialer(int n) {
        long[][] m = new long[10][10];
        m[0][4] = 1;
        m[0][6] = 1;
        m[1][6] = 1;
        m[1][8] = 1;
        m[2][7] = 1;
        m[2][9] = 1;
        m[3][4] = 1;
        m[3][8] = 1;
        m[4][0] = 1;
        m[4][3] = 1;
        m[4][9] = 1;
        m[6][0] = 1;
        m[6][1] = 1;
        m[6][7] = 1;
        m[7][2] = 1;
        m[7][6] = 1;
        m[8][1] = 1;
        m[8][3] = 1;
        m[9][2] = 1;
        m[9][4] = 1;
        long[] arr = new long[10];
        Arrays.fill(arr, 1);
        arr = qPow(arr, m, n - 1);
        long res = 0;
        for (long num : arr) {
            res += num;
        }
        return (int) (res % mod);
    }

    int mod = 1_000_000_007;

    public long[] qPow(long[] a, long[][] b, int t) {
        while (t > 0) {
            if (t % 2 == 1)
                a = pro(a, b);
            b = pow(b);
            t /= 2;
        }
        return a;
    }

    public long[][] pow(long[][] a) {
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

    public long[] pro(long[] a, long[][] b) {
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
