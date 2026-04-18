#
# Problem: 1594. Maximum Non Negative Product in a Matrix
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/
# Language: python3
# Date: 2026-04-18


class Solution:
    def maxProductPath(self, grid: List[List[int]]) -> int:
        dp_min = []
        dp_max = []
        pro = 1
        for num in grid[0]:
            pro *= num
            dp_min.append(pro)
            dp_max.append(pro)
        for i in range(1, len(grid)):
            temp_min = dp_min[0]
            temp_max = dp_max[0]
            dp_min[0] = min(temp_max * grid[i][0], temp_min * grid[i][0])
            dp_max[0] = max(temp_max * grid[i][0], temp_min * grid[i][0])
            for j in range(1, len(grid[0])):
                temp_min = dp_min[j]
                temp_max = dp_max[j]
                dp_min[j] = min(
                    temp_max * grid[i][j],
                    temp_min * grid[i][j],
                    dp_max[j - 1] * grid[i][j],
                    dp_min[j - 1] * grid[i][j],
                )
                dp_max[j] = max(
                    temp_max * grid[i][j],
                    temp_min * grid[i][j],
                    dp_max[j - 1] * grid[i][j],
                    dp_min[j - 1] * grid[i][j],
                )
        if dp_max[-1] < 0:
            return -1
        return dp_max[-1] % 1_000_000_007

