#
# Problem: 2711. Difference of Number of Distinct Values on Diagonals
# Difficulty: Medium
# Link: https://leetcode.com/problems/difference-of-number-of-distinct-values-on-diagonals/
# Language: python3
# Date: 2026-04-30


class Solution:
    def differenceOfDistinctValues(self, grid: List[List[int]]) -> List[List[int]]:
        res = [[0] * len(grid[0]) for _ in range(len(grid))]
        for i in range(len(grid)):
            x = i
            y = 0
            seens = [False] * 51
            count = 0
            while x < len(grid) and y < len(grid[0]):
                res[x][y] = count
                if not seens[grid[x][y]]:
                    seens[grid[x][y]] = True
                    count += 1
                x += 1
                y += 1
            x -= 1
            y -= 1
            seens = [False] * 51
            count = 0
            while x >= 0 and y >= 0:
                res[x][y] = abs(res[x][y] - count)
                if not seens[grid[x][y]]:
                    seens[grid[x][y]] = True
                    count += 1
                x -= 1
                y -= 1
        for i in range(1, len(grid[0])):
            x = 0
            y = i
            seens = [False] * 51
            count = 0
            while x < len(grid) and y < len(grid[0]):
                res[x][y] = count
                if not seens[grid[x][y]]:
                    seens[grid[x][y]] = True
                    count += 1
                x += 1
                y += 1
            x -= 1
            y -= 1
            seens = [False] * 51
            count = 0
            while x >= 0 and y >= 0:
                res[x][y] = abs(res[x][y] - count)
                if not seens[grid[x][y]]:
                    seens[grid[x][y]] = True
                    count += 1
                x -= 1
                y -= 1
        return res

