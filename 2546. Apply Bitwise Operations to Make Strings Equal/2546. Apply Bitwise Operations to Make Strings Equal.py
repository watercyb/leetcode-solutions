#
# Problem: 2546. Apply Bitwise Operations to Make Strings Equal
# Difficulty: Medium
# Link: https://leetcode.com/problems/apply-bitwise-operations-to-make-strings-equal/
# Language: python3
# Date: 2026-04-28


class Solution:
    def makeStringsEqual(self, s: str, target: str) -> bool:
        return s == target or ("1" in s and "1" in target)

