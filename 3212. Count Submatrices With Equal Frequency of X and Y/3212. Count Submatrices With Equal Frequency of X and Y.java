/*
 * Problem: 3212. Count Submatrices With Equal Frequency of X and Y
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int[] DP = new int[grid[0].length];
        boolean[] notEmpty = new boolean[grid[0].length];
        int[] nums = new int['Z'];
        nums['X'] = 1;
        nums['Y'] = -1;
        DP[0] = nums[grid[0][0]];
        notEmpty[0] = grid[0][0] != '.';
        int res = 0;
        for (int i = 1; i < grid[0].length; i++) {
            DP[i] = DP[i - 1] + nums[grid[0][i]];
            notEmpty[i] = notEmpty[i - 1] | (grid[0][i] != '.');
            if (DP[i] == 0 && notEmpty[i])
                res++;
        }
        for (int i = 1; i < grid.length; i++) {
            int sum = 0;
            boolean left = false;
            for (int j = 0; j < grid[0].length; j++) {
                sum += nums[grid[i][j]];
                DP[j] += sum;
                left |= (grid[i][j] != '.');
                notEmpty[j] |= left;
                if (DP[j] == 0 && notEmpty[j])
                    res++;
            }
        }
        return res;
    }
}
