/*
 * Problem: 1314. Matrix Block Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/matrix-block-sum/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] res = new int[mat.length][mat[0].length];
        int sum = 0;
        int l1 = Math.min(k, mat.length - 1);
        int l2 = Math.min(k, mat[0].length - 1);
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                sum += mat[i][j];
            }
        }
        res[0][0] = sum;
        for (int i = 1; i < mat.length; i++) {
            if (i - k - 1 >= 0) {
                for (int j = 0; j <= l2; j++) {
                    sum -= mat[i - k - 1][j];
                }
            }
            if (i + k < mat.length) {
                for (int j = 0; j <= l2; j++) {
                    sum += mat[i + k][j];
                }
            }
            res[i][0] = sum;
        }
        for (int i = 1; i < mat[0].length; i++) {
            for (int j = 0; j < mat.length; j++) {
                sum = res[j][i - 1];
                l1 = Math.min(j + k, mat.length - 1);
                int l3=Math.max(j - k, 0);
                int ik=i - k - 1;
                if (ik >= 0) {
                    for (int l = l3; l <=  l1; l++) {
                        sum -= mat[l][ik];
                    }
                }
                ik=i + k;
                if (ik < mat[0].length) {
                    for (int l = l3; l <=  l1; l++) {
                        sum += mat[l][ik];
                    }
                }
                res[j][i] = sum;
            }
        }
        return res;
    }
}
