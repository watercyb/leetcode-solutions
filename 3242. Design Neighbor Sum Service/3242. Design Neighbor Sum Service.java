/*
 * Problem: 3242. Design Neighbor Sum Service
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/design-neighbor-sum-service/
 * Language: java
 * Date: 2026-05-05
 */

class NeighborSum {
    int[] sumAdj;
    int[] sumDiag;

    public NeighborSum(int[][] grid) {
        sumAdj = new int[grid.length * grid[0].length];
        sumDiag = new int[sumAdj.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i > 0)
                    sumAdj[grid[i][j]] += grid[i - 1][j];
                if (i < grid.length - 1)
                    sumAdj[grid[i][j]] += grid[i + 1][j];
                if (j > 0)
                    sumAdj[grid[i][j]] += grid[i][j - 1];
                if (j < grid[0].length - 1)
                    sumAdj[grid[i][j]] += grid[i][j + 1];
                if (i > 0 && j > 0)
                    sumDiag[grid[i][j]] += grid[i - 1][j - 1];
                if (i < grid.length - 1 && j > 0)
                    sumDiag[grid[i][j]] += grid[i + 1][j - 1];
                if (i > 0 && j < grid[0].length - 1)
                    sumDiag[grid[i][j]] += grid[i - 1][j + 1];
                if (i < grid.length - 1 && j < grid[0].length - 1)
                    sumDiag[grid[i][j]] += grid[i + 1][j + 1];
            }
        }
    }

    public int adjacentSum(int value) {
        return sumAdj[value];
    }

    public int diagonalSum(int value) {
        return sumDiag[value];
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */
