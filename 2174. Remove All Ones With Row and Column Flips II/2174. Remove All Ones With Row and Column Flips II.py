#
# Problem: 2174. Remove All Ones With Row and Column Flips II
# Difficulty: Medium
# Link: https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips-ii/
# Language: python3
# Date: 2026-04-24


class Solution:
    def removeOnes(self, grid: List[List[int]]) -> int:
        row = len(grid)
        col = len(grid[0])
        rows = [False] * row
        cols = [False] * col

        def dfs(i: int, j: int) -> int:
            if j == col:
                i += 1
                j = 0
            if i == row:
                for r in range(row):
                    for c in range(col):
                        if grid[r][c] == 1 and not rows[r] and not cols[c]:
                            return row * col
                return 0
            if grid[i][j] == 0 or rows[i] or cols[j]:
                return dfs(i, j + 1)
            res = dfs(i, j + 1)
            rows[i] = True
            cols[j] = True
            res = min(res, dfs(i, j + 1) + 1)
            rows[i] = False
            cols[j] = False
            return res

        return dfs(0, 0)

