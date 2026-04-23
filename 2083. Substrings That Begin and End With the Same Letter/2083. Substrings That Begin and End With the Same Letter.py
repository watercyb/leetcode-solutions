#
# Problem: 2083. Substrings That Begin and End With the Same Letter
# Difficulty: Medium
# Link: https://leetcode.com/problems/substrings-that-begin-and-end-with-the-same-letter/
# Language: python3
# Date: 2026-04-23


class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        counter = Counter(s)
        res = 0
        for _, cnt in counter.items():
            res += (cnt + 1) * cnt // 2
        return res

