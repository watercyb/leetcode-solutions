/*
 * Problem: 308. Range Sum Query 2D - Mutable
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/range-sum-query-2d-mutable/?envType=weekly-question&envId=2026-08-15
 * Language: java
 * Date: 2026-08-15
 */

class NumMatrix {

    int[][] matrix;
    int[][] BIT;
    int r;
    int c;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        r = matrix.length + 1;
        c = matrix[0].length + 1;
        BIT = new int[r][c];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                insert(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        if (diff != 0) {
            matrix[row][col] = val;
            insert(row, col, diff);
        }
    }

    public void insert(int row, int col, int val) {
        row++;
        col++;
        for (int i = row; i < r; i += i & -i) {
            for (int j = col; j < c; j += j & -j) {
                BIT[i][j] += val;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return get(row2, col2) - get(row1 - 1, col2) - get(row2, col1 - 1) + get(row1 - 1, col1 - 1);
    }

    public int get(int row, int col) {
        row++;
        col++;
        int res = 0;
        for (int i = row; i > 0; i -= i & -i) {
            for (int j = col; j > 0; j -= j & -j) {
                res += BIT[i][j];
            }
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
