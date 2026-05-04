#
# Problem: 3125. Maximum Number That Makes Result of Bitwise AND Zero
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-number-that-makes-result-of-bitwise-and-zero/
# Language: python3
# Date: 2026-05-04


class Solution:
    def maxNumber(self, n: int) -> int:
        return (1 << (n.bit_length() - 1)) - 1

