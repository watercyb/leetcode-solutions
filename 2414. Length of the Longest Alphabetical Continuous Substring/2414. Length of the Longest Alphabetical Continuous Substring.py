#
# Problem: 2414. Length of the Longest Alphabetical Continuous Substring
# Difficulty: Medium
# Link: https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/
# Language: python3
# Date: 2026-04-27


class Solution:
    def longestContinuousSubstring(self, s: str) -> int:
        res = 0
        length = 1
        for i in range(1, len(s)):
            idx = ord(s[i]) - ord("a")
            prv = ord(s[i - 1]) - ord("a")
            if prv + 1 == idx:
                length += 1
            else:
                res = max(res, length)
                length = 1
            prv = idx
        res = max(res, length)
        return res

