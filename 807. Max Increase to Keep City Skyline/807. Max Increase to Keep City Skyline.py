#
# Problem: 807. Max Increase to Keep City Skyline
# Difficulty: Medium
# Link: https://leetcode.com/problems/max-increase-to-keep-city-skyline/
# Language: python3
# Date: 2026-04-09


class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        max_row = [0] * len(grid)
        max_col = [0] * len(grid[0])
        for i in range(len(grid)):
            max_row[i] = max(grid[i])
        for i in range(len(grid[0])):
            max_col[i] = max(grid[j][i] for j in range(len(grid)))
        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                res += min(max_row[i], max_col[j]) - grid[i][j]
        return sum(
            min(max_row[i], max_col[j]) - grid[i][j]
            for i in range(len(grid))
            for j in range(len(grid[i]))
        )

