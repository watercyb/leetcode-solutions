#
# Problem: 2556. Disconnect Path in a Binary Matrix by at Most One Flip
# Difficulty: Medium
# Link: https://leetcode.com/problems/disconnect-path-in-a-binary-matrix-by-at-most-one-flip/
# Language: python3
# Date: 2026-04-28


class Solution:
    def isPossibleToCutPath(self, grid: List[List[int]]) -> bool:
        def dfs(i: int, j: int, dirts: List[int]) -> bool:
            if i == len(grid) - 1 and j == len(grid[0]) - 1:
                return True
            grid[i][j] = 0
            for dirt in dirts:
                x = i + dirt[0]
                y = j + dirt[1]
                if (
                    x < len(grid)
                    and y < len(grid[0])
                    and grid[x][y] == 1
                    and dfs(x, y, dirts)
                ):
                    return True
            return False

        if len(grid) == 1:
            return len(grid[0]) > 2
        if len(grid[0]) == 1:
            return len(grid) > 2
        if grid[1][0] == 0 and grid[0][1]:
            return True
        if not dfs(1, 0, [[1, 0], [0, 1]]):
            return True
        return not dfs(0, 1, [[0, 1], [1, 0]])

