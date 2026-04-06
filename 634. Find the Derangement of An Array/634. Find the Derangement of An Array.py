#
# Problem: 634. Find the Derangement of An Array
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-the-derangement-of-an-array/
# Language: python3
# Date: 2026-04-06


class Solution:
    def findDerangement(self, n: int) -> int:
        a = 1
        b = 0
        for i in range(n, 1, -1):
            temp = a + b
            a = b
            b = temp * (i - 1) % 1_000_000_007
        return b

