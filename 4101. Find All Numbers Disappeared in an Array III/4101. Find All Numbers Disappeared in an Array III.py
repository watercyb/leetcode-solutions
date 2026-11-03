#
# Problem: 4101. Find All Numbers Disappeared in an Array III
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array-iii/
# Language: python3
# Date: 2026-11-03


class Solution:
    def findDisappearedNumbers(
        self, nums: list[int], lower: int, upper: int
    ) -> list[list[int]]:
        nums.sort()
        res = []
        prv = lower
        idx = 0
        while idx < len(nums) and nums[idx] < lower:
            idx += 1
        while idx < len(nums) and nums[idx] <= upper:
            if nums[idx] > prv:
                res.append([prv, nums[idx] - 1])
                prv = nums[idx] + 1
            else:
                prv = nums[idx] + 1
            idx += 1
        if prv <= upper:
            res.append([prv, upper])
        return res

