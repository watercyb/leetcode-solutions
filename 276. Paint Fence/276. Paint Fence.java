/*
 * Problem: 276. Paint Fence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/paint-fence/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int numWays(int n, int k) {
        int[][] res = { { k, 0 } };
        int[][] matrix = { { k - 1, 1 }, { k - 1, 0 } };
        n -= 1;
        while (n > 0) {
            if (n % 2 == 1)
                res = multiply(res, matrix);
            n /= 2;
            matrix = multiply(matrix, matrix);
        }
        return res[0][0] + res[0][1];
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] res = new int[a.length][b[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                int tmp = 0;
                for (int k = 0; k < b.length; k++) {
                    tmp += a[i][k] * b[k][j];
                }
                res[i][j] = tmp;
            }
        }
        return res;
    }
}
