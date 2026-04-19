#
# Problem: 1638. Count Substrings That Differ by One Character
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-substrings-that-differ-by-one-character/
# Language: python3
# Date: 2026-04-19


class Solution:
    def countSubstrings(self, s: str, t: str) -> int:
        def chk(i: int, j: int) -> int:
            res = 0
            a = 0
            b = 0
            while i < len(s) and j < len(t):
                if s[i] == t[j]:
                    a += 1
                    res += b
                else:
                    b = a + 1
                    a = 0
                    res += b
                i += 1
                j += 1
            return res

        res = 0
        for i in range(len(s)):
            res += chk(i, 0)
        for i in range(1, len(t)):
            res += chk(0, i)
        return res

