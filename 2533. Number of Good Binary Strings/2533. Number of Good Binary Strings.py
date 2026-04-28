#
# Problem: 2533. Number of Good Binary Strings
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-good-binary-strings/
# Language: python3
# Date: 2026-04-28


class Solution:
    def goodBinaryStrings(
        self, minLength: int, maxLength: int, oneGroup: int, zeroGroup: int
    ) -> int:
        mod = 1_000_000_007
        dp = [0] * (maxLength + max(oneGroup, zeroGroup) + 1)
        dp[0] = 1
        for i in range(maxLength):
            dp[i + oneGroup] = (dp[i + oneGroup] + dp[i]) % mod
            dp[i + zeroGroup] = (dp[i + zeroGroup] + dp[i]) % mod
        return sum(dp[minLength : maxLength + 1]) % mod

