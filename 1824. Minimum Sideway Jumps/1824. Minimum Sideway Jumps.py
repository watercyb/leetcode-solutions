#
# Problem: 1824. Minimum Sideway Jumps
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-sideway-jumps/
# Language: python3
# Date: 2026-04-21


class Solution:
    def minSideJumps(self, obstacles: List[int]) -> int:
        dp = [1000000, 0, 1000000]
        prv = -1
        for i in obstacles:
            if i != 0:
                a = i - 1
                b = i % 3
                c = (i + 1) % 3
                if prv != b:
                    dp[b] = min(dp[a] + 1, dp[b])
                if prv != c:
                    dp[c] = min(dp[a] + 1, dp[c])
                dp[a] = 1000000
            prv = i - 1
        return min(dp)

