/*
 * Problem: 3933. Largest Local Values in a Matrix II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/largest-local-values-in-a-matrix-ii/
 * Language: java
 * Date: 2026-05-19
 */

class Solution {
    public int countLocalMaximums(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, matrix[i][j]);
            }
        }
        int[][][] counts = new int[matrix.length + 1][matrix[0].length + 1][max + 1];
        for (int i = 0; i < matrix.length; i++) {
            int[] c = new int[max + 1];
            for (int j = 0; j < matrix[0].length; j++) {
                c[matrix[i][j]]++;
                for (int k = 0; k <= max; k++) {
                    counts[i + 1][j + 1][k] = counts[i][j + 1][k] + c[k];
                }
            }
        }
        for (int i = 1; i < counts.length; i++) {
            for (int j = 1; j < counts[0].length; j++) {
                for (int k = max - 1; k >= 0; k--) {
                    counts[i][j][k] += counts[i][j][k + 1];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0 && get(counts, matrix, i, j))
                    res++;
            }
        }
        return res;
    }

    public boolean get(int[][][] counts, int[][] matrix, int i, int j) {
        int num = matrix[i][j];
        int x1 = i - num;
        int x2 = i + num + 1;
        int x3 = i + num;
        int y1 = j - num;
        int y2 = j + num + 1;
        int y3 = j + num;
        return get(counts, x2, y2, num + 1) - get(counts, x1, y2, num + 1)
                - get(counts, x2, y1, num + 1) + get(counts, x1, y1, num + 1)
                - get(matrix, x3, y3, num) - get(matrix, x1, y3, num)
                - get(matrix, x3, y1, num) - get(matrix, x1, y1, num) == 0;
    }

    public int get(int[][][] counts, int i, int j, int n) {
        if (i <= 0 || j <= 0 || n >= counts[0][0].length)
            return 0;
        if (i >= counts.length)
            i = counts.length - 1;
        if (j >= counts[0].length)
            j = counts[0].length - 1;
        return counts[i][j][n];
    }

    public int get(int[][] matrix, int i, int j, int n) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= n)
            return 0;
        return 1;
    }
}
