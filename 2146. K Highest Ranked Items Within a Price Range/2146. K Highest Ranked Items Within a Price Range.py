#
# Problem: 2146. K Highest Ranked Items Within a Price Range
# Difficulty: Medium
# Link: https://leetcode.com/problems/k-highest-ranked-items-within-a-price-range/
# Language: python3
# Date: 2026-04-24


class Solution:
    def highestRankedKItems(
        self, grid: List[List[int]], pricing: List[int], start: List[int], k: int
    ) -> List[List[int]]:
        res = []
        arr = [start]
        grid[start[0]][start[1]] = -grid[start[0]][start[1]]
        left = 0
        right = 1
        while left < right:
            lim = right
            li = []
            while left < lim:
                current = arr[left]
                left += 1
                x = current[0]
                y = current[1]
                p = -grid[x][y]
                if p >= pricing[0] and p <= pricing[1]:
                    li.append([p, x, y])
                if x > 0 and grid[x - 1][y] > 0:
                    grid[x - 1][y] = -grid[x - 1][y]
                    arr.append([x - 1, y])
                    right += 1
                if x < len(grid) - 1 and grid[x + 1][y] > 0:
                    grid[x + 1][y] = -grid[x + 1][y]
                    arr.append([x + 1, y])
                    right += 1
                if y > 0 and grid[x][y - 1] > 0:
                    grid[x][y - 1] = -grid[x][y - 1]
                    arr.append([x, y - 1])
                    right += 1
                if y < len(grid[0]) - 1 and grid[x][y + 1] > 0:
                    grid[x][y + 1] = -grid[x][y + 1]
                    arr.append([x, y + 1])
                    right += 1
            li.sort(key=lambda x: (x[0], x[1], x[2]))
            if len(res) + len(li) < k:
                for pair in li:
                    res.append([pair[1], pair[2]])
            else:
                for i in range(k - len(res)):
                    res.append([li[i][1], li[i][2]])
                break
        return res

