#
# Problem: 3301. Maximize the Total Height of Unique Towers
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximize-the-total-height-of-unique-towers/
# Language: python3
# Date: 2026-05-06


class Solution:
    def maximumTotalSum(self, maximumHeight: List[int]) -> int:
        maximumHeight.sort()
        res = 0
        max_height = 1000000000
        for x in reversed(maximumHeight):
            max_height = min(max_height, x)
            res += max_height
            max_height -= 1
            if max_height==-1:
                return -1
        return res

