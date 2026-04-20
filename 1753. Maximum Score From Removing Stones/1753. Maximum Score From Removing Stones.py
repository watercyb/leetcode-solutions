#
# Problem: 1753. Maximum Score From Removing Stones
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-score-from-removing-stones/
# Language: python3
# Date: 2026-04-20


class Solution:
    def maximumScore(self, a: int, b: int, c: int) -> int:
        max_val = max(a, b, c)
        if a + b + c < 2 * max_val:
            return a + b + c - max_val
        return (a + b + c) // 2

