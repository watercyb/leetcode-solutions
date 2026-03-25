/*
 * Problem: 63. Unique Paths II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/unique-paths-ii/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] != 0)
            return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] DP = new int[row + 1][col + 1];
        DP[1][0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 0)
                    DP[i + 1][j + 1] = DP[i][j + 1] + DP[i + 1][j];
            }
        }
        return DP[row][col];
    }
}
