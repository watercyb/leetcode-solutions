#
# Problem: 3784. Minimum Deletion Cost to Make All Characters Equal
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-deletion-cost-to-make-all-characters-equal/
# Language: python3
# Date: 2026-05-10


class Solution:
    def minCost(self, s: str, cost: List[int]) -> int:
        costs = [0] * 26
        total = 0
        for i in range(len(s)):
            costs[ord(s[i]) - ord("a")] += cost[i]
            total += cost[i]
        return total - max(costs)

