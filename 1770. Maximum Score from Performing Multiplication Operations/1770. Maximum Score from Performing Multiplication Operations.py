#
# Problem: 1770. Maximum Score from Performing Multiplication Operations
# Difficulty: Hard
# Link: https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
# Language: python3
# Date: 2026-04-20


class Solution:
    def maximumScore(self, nums: List[int], multipliers: List[int]) -> int:
        n = len(nums)
        m = len(multipliers)
        p = n - m
        DP = [[0 for _ in range(m)] for _ in range(m)]
        for i in range(0, m):
            DP[i][i] = max(
                nums[i] * multipliers[m - 1], nums[i + p] * multipliers[m - 1]
            )
        for i in range(1, m):
            for j in range(0, m - i):
                k = j + i
                DP[j][k] = max(
                    DP[j + 1][k] + nums[j] * multipliers[m - 1 - i],
                    DP[j][k - 1] + nums[k + p] * multipliers[m - 1 - i],
                )
        return DP[0][m - 1]

