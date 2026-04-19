#
# Problem: 1641. Count Sorted Vowel Strings
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-sorted-vowel-strings/
# Language: python3
# Date: 2026-04-19


class Solution:
    def countVowelStrings(self, n: int) -> int:
        dp = [1] * 5
        for i in range(n - 1):
            sm = 0
            for j in range(0, 5):
                sm += dp[j]
                dp[j] = sm
        return sum(dp)

