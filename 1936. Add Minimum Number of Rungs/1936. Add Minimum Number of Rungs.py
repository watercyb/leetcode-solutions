#
# Problem: 1936. Add Minimum Number of Rungs
# Difficulty: Medium
# Link: https://leetcode.com/problems/add-minimum-number-of-rungs/
# Language: python3
# Date: 2026-04-22


class Solution:
    def addRungs(self, rungs: List[int], dist: int) -> int:
        res = 0
        prv = 0
        for rung in rungs:
            res += (rung - prv - 1) // dist
            prv = rung
        return res

