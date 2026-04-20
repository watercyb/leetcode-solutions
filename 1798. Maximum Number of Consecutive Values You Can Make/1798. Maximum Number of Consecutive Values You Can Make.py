#
# Problem: 1798. Maximum Number of Consecutive Values You Can Make
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/
# Language: python3
# Date: 2026-04-20


class Solution:
    def getMaximumConsecutive(self, coins: List[int]) -> int:
        coins.sort()
        res = 1
        for coin in coins:
            if coin > res:
                return res
            res += coin
        return res

