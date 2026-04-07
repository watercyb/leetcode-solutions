#
# Problem: 3125. Maximum Number That Makes Result of Bitwise AND Zero
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-number-that-makes-result-of-bitwise-and-zero/?envType=problem-list-v2&envId=string
# Language: python3
# Date: 2026-04-07


class Solution:
    def maxNumber(self, n: int) -> int:
        return (1 << (n.bit_length() - 1)) - 1

