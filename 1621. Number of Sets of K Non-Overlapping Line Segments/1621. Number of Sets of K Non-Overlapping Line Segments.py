#
# Problem: 1621. Number of Sets of K Non-Overlapping Line Segments
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/
# Language: python3
# Date: 2026-04-19


class Solution:
    def numberOfSets(self, n: int, k: int) -> int:
        mod = 1_000_000_007
        dp = [0] * (k + 1)
        dp_1 = [0] * (k + 1)
        dp[0] = 1
        res = 0
        for _ in range(n - 1):
            dp_next = [0] * (k + 1)
            dp_1_next = [0] * (k + 1)
            dp_1_next[0] = dp_1[0]
            for i in range(k):
                dp_next[i] = (dp[i] + dp_1[i]) % mod
                dp_1_next[i + 1] = (dp[i] + dp_1[i] + dp_1[i + 1]) % mod
            dp = dp_next
            dp_1 = dp_1_next
            res += dp_1[k]
        return res % mod

