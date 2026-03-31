/*
 * Problem: 304. Range Sum Query 2D - Immutable
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/range-sum-query-2d-immutable/
 * Language: java
 * Date: 2026-03-31
 */

class NumMatrix {
    int[][] m;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;
        m=new int[matrix.length+1][matrix[0].length+1];
        for (int i=0;i<matrix.length;i++) {
            int tmp=0;
            for (int j=0;j<matrix[0].length;j++) {
                tmp+=matrix[i][j];
                m[i+1][j+1]=m[i][j+1]+tmp;;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1==row2&&col1==col2) return matrix[row1][col1];
        int res=m[row2+1][col2+1];
        res-=m[row1][col2+1];
        res-=m[row2+1][col1];
        res+=m[row1][col1];
        return res;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
