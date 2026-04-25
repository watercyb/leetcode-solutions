#
# Problem: 2245. Maximum Trailing Zeros in a Cornered Path
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-trailing-zeros-in-a-cornered-path/
# Language: python3
# Date: 2026-04-25


class Solution:
    def maxTrailingZeros(self, grid: List[List[int]]) -> int:
        rows2 = [[0] * len(grid[0]) for _ in range(len(grid))]
        rows5 = [[0] * len(grid[0]) for _ in range(len(grid))]
        cols2 = [[0] * len(grid[0]) for _ in range(len(grid))]
        cols5 = [[0] * len(grid[0]) for _ in range(len(grid))]

        def getCount(num: int) -> List[idx]:
            a = 0
            while num % 2 == 0:
                a += 1
                num /= 2
            b = 0
            while num % 5 == 0:
                b += 1
                num /= 5
            return [a, b]

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                pair = getCount(grid[i][j])
                if i == 0:
                    cols2[i][j] = pair[0]
                    cols5[i][j] = pair[1]
                else:
                    cols2[i][j] = cols2[i - 1][j] + pair[0]
                    cols5[i][j] = cols5[i - 1][j] + pair[1]
                if j == 0:
                    rows2[i][j] = pair[0]
                    rows5[i][j] = pair[1]
                else:
                    rows2[i][j] = rows2[i][j - 1] + pair[0]
                    rows5[i][j] = rows5[i][j - 1] + pair[1]
        res = 0
        for i in range(len(grid) - 1, -1, -1):
            for j in range(len(grid[0]) - 1, -1, -1):
                pair = getCount(grid[i][j])
                col2 = 0
                col5 = 0
                row2 = 0
                row5 = 0
                if i < len(grid) - 1:
                    col2 = cols2[i + 1][j]
                    col5 = cols5[i + 1][j]
                if j < len(grid[0]) - 1:
                    row2 = rows2[i][j + 1]
                    row5 = rows5[i][j + 1]
                res = max(res, min(cols2[i][j] + row2, cols5[i][j] + row5))
                res = max(
                    res,
                    min(
                        cols2[i][j] + rows2[i][j] - pair[0],
                        cols5[i][j] + rows5[i][j] - pair[1],
                    ),
                )
                res = max(res, min(rows2[i][j] + col2, rows5[i][j] + col5))
                res = max(
                    res,
                    min(
                        row2 + col2 + pair[0],
                        row5 + col5 + pair[1],
                    ),
                )
                if i == len(grid) - 1:
                    cols2[i][j] = pair[0]
                    cols5[i][j] = pair[1]
                else:
                    cols2[i][j] = cols2[i + 1][j] + pair[0]
                    cols5[i][j] = cols5[i + 1][j] + pair[1]
                if j == len(grid[0]) - 1:
                    rows2[i][j] = pair[0]
                    rows5[i][j] = pair[1]
                else:
                    rows2[i][j] = rows2[i][j + 1] + pair[0]
                    rows5[i][j] = rows5[i][j + 1] + pair[1]
        return res

