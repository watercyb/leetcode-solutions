#
# Problem: 2680. Maximum OR
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-or/
# Language: python3
# Date: 2026-04-29


class Solution:
    def maximumOr(self, nums: List[int], k: int) -> int:
        lefts = []
        or_val = 0
        for num in nums:
            lefts.append(or_val)
            or_val |= num
        rights = [0] * len(nums)
        or_val = 0
        for i in range(len(nums) - 1, -1, -1):
            rights[i] = or_val
            or_val |= nums[i]
        res = 0
        for i in range(len(nums)):
            res = max(res, nums[i] << k | lefts[i] | rights[i])
        return res

