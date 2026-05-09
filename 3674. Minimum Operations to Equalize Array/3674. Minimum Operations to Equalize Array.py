#
# Problem: 3674. Minimum Operations to Equalize Array
# Difficulty: Easy
# Link: https://leetcode.com/problems/minimum-operations-to-equalize-array/
# Language: python3
# Date: 2026-05-09


class Solution:
    def minOperations(self, nums: List[int]) -> int:
        if len(set(nums)) == 1:
            return 0
        return 1

