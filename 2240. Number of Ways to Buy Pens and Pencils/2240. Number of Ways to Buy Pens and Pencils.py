#
# Problem: 2240. Number of Ways to Buy Pens and Pencils
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/
# Language: python3
# Date: 2026-04-25


class Solution:
    def waysToBuyPensPencils(self, total: int, cost1: int, cost2: int) -> int:
        res = 0
        while total >= 0:
            res += total // cost2 + 1
            total -= cost1
        return res

