#
# Problem: 3128. Right Triangles
# Difficulty: Medium
# Link: https://leetcode.com/problems/right-triangles/
# Language: python3
# Date: 2026-05-04


class Solution:
    def numberOfRightTriangles(self, grid: List[List[int]]) -> int:
        res = 0
        row = len(grid)
        col = len(grid[0])
        row_counts = []
        for i in range(0, row):
            sum = -1
            for j in range(0, col):
                sum += grid[i][j]
            row_counts.append(sum)
        for i in range(0, col):
            sum = 0
            count = -1
            for j in range(0, row):
                if grid[j][i] == 1:
                    sum += row_counts[j]
                    count += 1
            res += sum * count
        return res

