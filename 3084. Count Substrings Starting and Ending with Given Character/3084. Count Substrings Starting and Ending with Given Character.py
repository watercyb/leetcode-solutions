#
# Problem: 3084. Count Substrings Starting and Ending with Given Character
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/
# Language: python3
# Date: 2026-05-03


class Solution:
    def countSubstrings(self, s: str, c: str) -> int:
        count = s.count(c)
        return (count + 1) * count // 2

