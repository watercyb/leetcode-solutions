#
# Problem: 3183. The Number of Ways to Make the Sum
# Difficulty: Medium
# Link: https://leetcode.com/problems/the-number-of-ways-to-make-the-sum/
# Language: python3
# Date: 2026-05-04


class Solution:
    def numberOfWays(self, n: int) -> int:
        mod = 1_000_000_007

        def getCount(n: int) -> int:
            dp = [1] * (n + 1)
            for i in range(n - 1):
                dp[i + 2] += dp[i]
            for i in range(n - 5):
                dp[i + 6] += dp[i]
            res = dp[n]
            if n >= 4:
                res += dp[n - 4]
            if n >= 8:
                res += dp[n - 8]
            return res

        return getCount(n) % mod

