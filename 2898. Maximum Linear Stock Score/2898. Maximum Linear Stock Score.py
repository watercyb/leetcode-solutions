#
# Problem: 2898. Maximum Linear Stock Score
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-linear-stock-score/?envType=problem-list-v2&envId=hash-table
# Language: python3
# Date: 2026-04-03


class Solution:
    def maxScore(self, prices: List[int]) -> int:
        mp = {}
        for i in range(len(prices)):
            idx = prices[i] - i
            mp[idx] = mp.get(idx, 0) + prices[i]
        return max(mp.values())

