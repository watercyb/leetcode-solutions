#
# Problem: 2358. Maximum Number of Groups Entering a Competition
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/
# Language: python3
# Date: 2026-04-26


class Solution:
    def maximumGroups(self, grades: List[int]) -> int:
        res = 0
        length = 1
        total_length = len(grades)
        while length <= total_length:
            total_length -= length
            length += 1
            res += 1
        return res

