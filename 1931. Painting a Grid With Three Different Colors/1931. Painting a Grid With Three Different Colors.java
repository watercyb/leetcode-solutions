/*
 * Problem: 1931. Painting a Grid With Three Different Colors
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/painting-a-grid-with-three-different-colors/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int colorTheGrid(int m, int n) {
        int mod = 1_000_000_007;
        int len = (int) Math.pow(3, m);
        hToH1 = new int[len];
        h1Indexes = new int[len];
        List<Integer> list = new ArrayList<>();
        dfs(list, 0, 0, 0, -1, m);
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        long[][] matrix = new long[h1Idx][h1Idx];
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (chk(arr[i], arr[j], m)) {
                    matrix[hToH1[arr[i]] - 1][hToH1[arr[j]] - 1] += 1;
                    matrix[hToH1[arr[j]] - 1][hToH1[arr[i]] - 1] += 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] /= 3;
            }
        }
        long[] DP = new long[h1Idx];
        for (int num : arr) {
            DP[hToH1[num] - 1]++;
        }
        n--;
        while (n > 0) {
            if (n % 2 == 1)
                DP = pro(DP, matrix, mod);
            matrix = pow(matrix, mod);
            n /= 2;
        }
        long res = 0;
        for (long count : DP) {
            res += count;
        }
        return (int) (res % mod);
    }

    public boolean chk(int a, int b, int m) {
        for (int i = 0; i < m; i++) {
            if (a % 3 == b % 3)
                return false;
            a /= 3;
            b /= 3;
        }
        return true;
    }

    int[] hToH1;
    int[] h1Indexes;
    int h1Idx = 0;

    public void dfs(List<Integer> list, int i, int h, int h1, int prv, int m) {
        if (i == m) {
            list.add(h);
            if (h1Indexes[h1] == 0)
                h1Indexes[h1] = ++h1Idx;
            hToH1[h] = h1Indexes[h1];
            return;
        }
        for (int j = 0; j < 3; j++) {
            if (j == prv)
                continue;
            if (i == 0) {
                dfs(list, i + 1, h * 3 + j, 0, j, m);
            } else {
                dfs(list, i + 1, h * 3 + j, h1 * 3 + (j - prv + 3) % 3, j, m);
            }
        }
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
