#
# Problem: 1559. Detect Cycles in 2D Grid
# Difficulty: Medium
# Link: https://leetcode.com/problems/detect-cycles-in-2d-grid/
# Language: python3
# Date: 2026-04-18


class Solution:
    def containsCycle(self, grid: List[List[str]]) -> bool:
        def find(links: List[int], i: int) -> int:
            if links[i] != i:
                links[i] = find(links, links[i])
            return links[i]

        def getIdx(i: int, j: int, c: int) -> int:
            return i * c + j

        r = len(grid)
        c = len(grid[0])

        links = [i for i in range(r * c)]
        for i in range(r):
            for j in range(1, c):
                if grid[i][j] == grid[i][j - 1]:
                    a = find(links, getIdx(i, j, c))
                    b = find(links, getIdx(i, j - 1, c))
                    links[a] = b
        for i in range(c):
            for j in range(1, r):
                if grid[j][i] == grid[j - 1][i]:
                    a = find(links, getIdx(j, i, c))
                    b = find(links, getIdx(j - 1, i, c))
                    if a == b:
                        return True
                    links[a] = b
        return False

