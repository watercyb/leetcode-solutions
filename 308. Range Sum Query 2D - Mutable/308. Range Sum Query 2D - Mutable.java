/*
 * Problem: 308. Range Sum Query 2D - Mutable
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/range-sum-query-2d-mutable/
 * Language: java
 * Date: 2026-03-31
 */

class NumMatrix {
    int[][] matrix;
    int[][] BITree;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        BITree = new int[matrix.length][matrix[0].length + 2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int k = j + 2;
                while (k < BITree[0].length) {
                    BITree[i][k] += matrix[i][j];
                    k += -k & k;
                }
            }
        }
    }

    public void update(int row, int col, int val) {
        insert(row, col + 2, val);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        res += getVal(row1, row2, col2 + 2) - getVal(row1, row2, col1 + 1);
        return res;
    }

    public void insert(int i, int j, int val) {
        if (val == matrix[i][j - 2])
            return;
        int tmp = matrix[i][j - 2];
        matrix[i][j - 2] = val;
        val -= tmp;
        while (j < BITree[0].length) {
            BITree[i][j] += val;
            j += -j & j;
        }
    }

    public int getVal(int row1, int row2, int j) {
        int res = 0;
        while (j > 0) {
            for (int i = row1; i <= row2; i++) {
                res += BITree[i][j];
            }
            j -= -j & j;
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
