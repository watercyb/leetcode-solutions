/*
 * Problem: 3933. Largest Local Values in a Matrix II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/largest-local-values-in-a-matrix-ii/
 * Language: java
 * Date: 2026-05-28
 */

class Solution {
    public int countLocalMaximums(int[][] matrix) {
        boolean[] seens = new boolean[201];
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!seens[matrix[i][j]]) {
                    seens[matrix[i][j]] = true;
                    count++;
                }
            }
        }
        if (!seens[0])
            count++;
        int[] indexes = new int[201];
        seens[0] = true;
        int idx = 1;
        for (int i = 1; i < 201; i++) {
            if (seens[i]) {
                indexes[i] = idx++;
            }
        }
        int[][][] counts = new int[matrix.length + 1][matrix[0].length + 1][count + 1];
        for (int i = 0; i < matrix.length; i++) {
            int[] c = new int[count + 1];
            for (int j = 0; j < matrix[0].length; j++) {
                c[indexes[matrix[i][j]]]++;
                for (int k = 0; k <= count; k++) {
                    counts[i + 1][j + 1][k] = counts[i][j + 1][k] + c[k];
                }
            }
        }
        for (int i = 1; i < counts.length; i++) {
            for (int j = 1; j < counts[0].length; j++) {
                for (int k = count - 1; k >= 0; k--) {
                    counts[i][j][k] += counts[i][j][k + 1];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0 && get(counts, indexes, matrix, i, j))
                    res++;
            }
        }
        return res;
    }

    public boolean get(int[][][] counts, int[] indexes, int[][] matrix, int i, int j) {
        int num = matrix[i][j];
        int x1 = i - num;
        int x2 = i + num + 1;
        int x3 = i + num;
        int y1 = j - num;
        int y2 = j + num + 1;
        int y3 = j + num;
        return get(counts, x2, y2, indexes[num] + 1) - get(counts, x1, y2, indexes[num] + 1)
                - get(counts, x2, y1, indexes[num] + 1) + get(counts, x1, y1, indexes[num] + 1)
                - get(matrix, indexes, x3, y3, indexes[num]) - get(matrix, indexes, x1, y3, indexes[num])
                - get(matrix, indexes, x3, y1, indexes[num]) - get(matrix, indexes, x1, y1, indexes[num]) == 0;
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

    public int get(int[][] matrix, int[] indexes, int i, int j, int n) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || indexes[matrix[i][j]] <= n)
            return 0;
        return 1;
    }
}
