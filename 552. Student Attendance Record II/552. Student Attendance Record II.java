/*
 * Problem: 552. Student Attendance Record II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/student-attendance-record-ii/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public int checkRecord(int n) {
        long[][] res = matrixPro(new long[][] { { 0, 0, 0, 0, 0, 1 } }, matrixPow(n));
        long sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += res[0][i];
        }
        return (int) (sum % mod);
    }

    int mod = 1_000_000_007;
    long[][] matrix = { { 0, 0, 1, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0 }, { 0, 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0, 1 },
            { 0, 0, 1, 1, 0, 1 }, { 0, 0, 1, 0, 1, 1 } };

    public long[][] matrixPow(int n) {
        long[][] res = new long[6][6];
        for (int i = 0; i < 6; i++) {
            res[i][i] = 1;
        }
        while (n > 0) {
            if (n % 2 == 1) {
                res = matrixPro(res, matrix);
                n--;
            } else {
                matrix = matrixPro(matrix, matrix);
                n /= 2;
            }
        }
        return res;
    }

    public long[][] matrixPro(long[][] a, long[][] b) {
        long[][] res = new long[a.length][b[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % mod;
                }
            }
        }
        return res;
    }
}
