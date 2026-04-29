#
# Problem: 2606. Find the Substring With Maximum Cost
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-the-substring-with-maximum-cost/
# Language: python3
# Date: 2026-04-29


class Solution:
    def maximumCostSubstring(self, s: str, chars: str, vals: List[int]) -> int:
        mp = {}
        for ch in string.ascii_lowercase:
            mp[ch] = ord(ch) - ord("a") + 1
        for i in range(len(chars)):
            mp[chars[i]] = vals[i]
        res = 0
        cost = 0
        for ch in s:
            cost += mp[ch]
            cost = max(cost, 0)
            res = max(res, cost)
        return res

