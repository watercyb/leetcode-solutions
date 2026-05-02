#
# Problem: 2952. Minimum Number of Coins to be Added
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-number-of-coins-to-be-added/
# Language: python3
# Date: 2026-05-02


class Solution:
    def minimumAddedCoins(self, coins: List[int], target: int) -> int:
        coins.sort()
        lim = 0
        res = 0
        for coin in coins:
            while lim < coin - 1:
                lim += lim + 1
                res += 1
            if lim >= target:
                break
            lim += coin
        while lim < target:
            lim += lim + 1
            res += 1
        return res

