#
# Problem: 3148. Maximum Difference Score in a Grid
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-difference-score-in-a-grid/
# Language: python3
# Date: 2026-05-04


class Solution:
    def maxScore(self, grid: List[List[int]]) -> int:
        dp = [1000000] * len(grid[0])
        res = -1000000
        for li in grid:
            res = max(res, li[0] - dp[0])
            dp[0] = min(dp[0], li[0])
            for i in range(1, len(li)):
                res = max(res, li[i] - min(dp[i - 1], dp[i]))
                dp[i] = min(dp[i], dp[i - 1], li[i])
        return res

