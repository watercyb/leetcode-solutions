#
# Problem: 1034. Coloring A Border
# Difficulty: Medium
# Link: https://leetcode.com/problems/coloring-a-border/
# Language: python3
# Date: 2026-04-11


class Solution:
    def colorBorder(
        self, grid: List[List[int]], row: int, col: int, color: int
    ) -> List[List[int]]:
        seens = [[False] * len(grid[0]) for _ in range(len(grid))]

        def dfs(x: int, y: int, target: int, color: int):
            seens[x][y] = True
            if x == 0 or (not seens[x - 1][y] and grid[x - 1][y] != target):
                grid[x][y] = color
            elif not seens[x - 1][y]:
                dfs(x - 1, y, target, color)
            if x == len(grid) - 1 or (not seens[x + 1][y] and grid[x + 1][y] != target):
                grid[x][y] = color
            elif not seens[x + 1][y]:
                dfs(x + 1, y, target, color)
            if y == 0 or (not seens[x][y - 1] and grid[x][y - 1] != target):
                grid[x][y] = color
            elif not seens[x][y - 1]:
                dfs(x, y - 1, target, color)
            if y == len(grid[0]) - 1 or (
                not seens[x][y + 1] and grid[x][y + 1] != target
            ):
                grid[x][y] = color
            elif not seens[x][y + 1]:
                dfs(x, y + 1, target, color)

        dfs(row, col, grid[row][col], color)
        return grid

