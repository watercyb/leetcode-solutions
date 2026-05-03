/*
 * Problem: 3070. Count Submatrices with Top-Left Element and Sum Less Than k
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        if (grid[0][0] > k)
            return 0;
        int res = 1;
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
            if (grid[0][i] > k)
                break;
            res++;
        }
        for (int i = 1; i < grid.length; i++) {
            int sum = 0;
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
                grid[i][j] = grid[i - 1][j] + sum;
                if (grid[i][j] > k)
                    break;
                res++;
            }
        }
        return res;
    }
}
