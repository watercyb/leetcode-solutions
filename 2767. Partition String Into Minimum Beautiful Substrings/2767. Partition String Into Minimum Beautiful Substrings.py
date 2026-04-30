#
# Problem: 2767. Partition String Into Minimum Beautiful Substrings
# Difficulty: Medium
# Link: https://leetcode.com/problems/partition-string-into-minimum-beautiful-substrings/
# Language: python3
# Date: 2026-04-30


class Solution:
    def minimumBeautifulSubstrings(self, s: str) -> int:
        st = set([1, 5, 25, 125, 625, 3125, 15625])
        dp = [len(s) + 1] * (len(s) + 1)
        dp[0] = 0
        for i in range(len(s)):
            if ord(s[i]) - ord("0") == 0:
                continue
            num = 0
            for j in range(i, len(s)):
                num = num * 2 + ord(s[j]) - ord("0")
                if num in st:
                    dp[j + 1] = min(dp[j + 1], dp[i] + 1)
        if dp[-1] == len(s) + 1:
            return -1
        return dp[-1]

