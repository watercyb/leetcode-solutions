#
# Problem: 2428. Maximum Sum of an Hourglass
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-sum-of-an-hourglass/
# Language: python3
# Date: 2026-04-27


class Solution:
    def maxSum(self, grid: List[List[int]]) -> int:
        res = 0
        for i in range(1, len(grid) - 1):
            for j in range(1, len(grid[0]) - 1):
                res = max(
                    res,
                    grid[i - 1][j - 1]
                    + grid[i - 1][j]
                    + grid[i - 1][j + 1]
                    + grid[i][j]
                    + grid[i + 1][j - 1]
                    + grid[i + 1][j]
                    + grid[i + 1][j + 1],
                )
        return res

