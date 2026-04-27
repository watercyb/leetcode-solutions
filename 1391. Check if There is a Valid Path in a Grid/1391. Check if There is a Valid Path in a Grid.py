#
# Problem: 1391. Check if There is a Valid Path in a Grid
# Difficulty: Medium
# Link: https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/?envType=daily-question&envId=2026-04-27
# Language: python3
# Date: 2026-04-27


class Solution:
    def hasValidPath(self, grid: List[List[int]]) -> bool:
        self.arr = [
            [
                [],
                [False, True, False, True, False, True, False],
                [False, False, False, False, False, False, False],
                [False, False, False, False, False, False, False],
                [False, True, False, True, False, True, False],
                [False, False, False, False, False, False, False],
                [False, True, False, True, False, True, False],
            ],
            [
                [],
                [False, False, False, False, False, False, False],
                [False, False, True, False, False, True, True],
                [False, False, True, False, False, True, True],
                [False, False, True, False, False, True, True],
                [False, False, False, False, False, False, False],
                [False, False, False, False, False, False, False],
            ],
            [
                [],
                [False, True, False, False, True, False, True],
                [False, False, False, False, False, False, False],
                [False, True, False, False, True, False, True],
                [False, False, False, False, False, False, False],
                [False, True, False, False, True, False, True],
                [False, False, False, False, False, False, False],
            ],
            [
                [],
                [False, False, False, False, False, False, False],
                [False, False, True, True, True, False, False],
                [False, False, False, False, False, False, False],
                [False, False, False, False, False, False, False],
                [False, False, True, True, True, False, False],
                [False, False, True, True, True, False, False],
            ],
        ]
        self.dirts = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        self.r = len(grid)
        self.l = len(grid[0])
        self.grid = grid

        def dfs(i: int, j: int) -> bool:
            if i == self.r - 1 and j == self.l - 1:
                return True
            for k in range(4):
                x = i + self.dirts[k][0]
                y = j + self.dirts[k][1]
                if (
                    x >= 0
                    and x < self.r
                    and y >= 0
                    and y < self.l
                    and not self.seens[x][y]
                    and self.arr[k][self.grid[i][j]][self.grid[x][y]]
                ):
                    self.seens[x][y] = True
                    if dfs(x, y):
                        return True
            return False

        self.seens = [[False] * self.l for _ in range(self.r)]
        self.seens[0][0] = True
        return dfs(0, 0)

