#
# Problem: Unknown Problem
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-cost-path-with-at-most-k-turns/
# Language: python3
# Date: 2026-09-06


class Solution:
    def minCost(self, grid: list[list[int]], k: int) -> int:
        DIRS = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        m, n = len(grid), len(grid[0])
        INF = 10**18
        costs = [
            [[[INF] * (k + 1) for _ in range(4)] for _ in range(n)] for _ in range(m)
        ]
        steps = [[[INF] * 4 for _ in range(n)] for _ in range(m)]

        pq = []
        for d in range(4):
            costs[0][0][d][0] = grid[0][0]
            heapq.heappush(pq, (grid[0][0], 0, 0, d, 0))

        while pq:
            c, x, y, d, t = heapq.heappop(pq)
            if c != costs[x][y][d][t] or steps[x][y][d] <= t:
                continue
            steps[x][y][d] = t
            if x == m - 1 and y == n - 1:
                return c

            for nd, (dx, dy) in enumerate(DIRS):
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n:
                    nt = t + (nd != d)
                    if nt <= k:
                        nc = c + grid[nx][ny]
                        if nc < costs[nx][ny][nd][nt]:
                            costs[nx][ny][nd][nt] = nc
                            heapq.heappush(pq, (nc, nx, ny, nd, nt))

        return -1

