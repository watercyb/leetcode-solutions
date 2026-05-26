#
# Problem: 3938. Maximum Path Intersection Sum in a Grid
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-path-intersection-sum-in-a-grid/
# Language: python3
# Date: 2026-05-26


class Solution:
    def maxScore(self, grid: List[List[int]]) -> int:
        res = -1000000
        for arr in grid:
            num_sum = arr[0]
            for i in range(1, len(arr)):
                if num_sum < arr[i - 1]:
                    num_sum = arr[i - 1]
                num_sum += arr[i]
                res = max(res, num_sum)
        for arr in zip(*grid):
            num_sum = arr[0]
            for i in range(1, len(arr)):
                if num_sum < arr[i - 1]:
                    num_sum = arr[i - 1]
                num_sum += arr[i]
                res = max(res, num_sum)
        for i in range(1, len(grid) - 1):
            for j in range(1, len(grid[0]) - 1):
                res = max(res, grid[i][j])
        return res

