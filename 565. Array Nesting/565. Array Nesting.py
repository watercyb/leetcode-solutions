#
# Problem: 565. Array Nesting
# Difficulty: Medium
# Link: https://leetcode.com/problems/array-nesting/
# Language: python3
# Date: 2026-08-26


class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        seens = [False] * len(nums)
        res = 0
        for i in range(len(nums)):
            l = 0
            idx = i
            while not seens[idx]:
                seens[idx] = True
                l += 1
                idx = nums[idx]
            res = max(res, l)
        return res

