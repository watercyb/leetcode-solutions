#
# Problem: 2712. Minimum Cost to Make All Characters Equal
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-cost-to-make-all-characters-equal/
# Language: python3
# Date: 2026-04-30


class Solution:
    def minimumCost(self, s: str) -> int:
        res = 0
        for i in range(1, len(s)):
            if s[i] != s[i - 1]:
                res += min(i, len(s) - i)
        return res

