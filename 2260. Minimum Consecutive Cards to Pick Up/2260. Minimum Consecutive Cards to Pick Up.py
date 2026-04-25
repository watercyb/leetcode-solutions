#
# Problem: 2260. Minimum Consecutive Cards to Pick Up
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/
# Language: python3
# Date: 2026-04-25


class Solution:
    def minimumCardPickup(self, cards: List[int]) -> int:
        idx = {}
        res = len(cards) + 1
        for i in range(len(cards)):
            if cards[i] in idx:
                res = min(res, i - idx.get(cards[i]) + 1)
            idx[cards[i]] = i
        if res > len(cards):
            return -1
        return res

