#
# Problem: 2708. Maximum Strength of a Group
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-strength-of-a-group/
# Language: python3
# Date: 2026-04-30


class Solution:
    def maxStrength(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        max_n = 0
        res = 1
        count = 0
        p = False
        zero = False
        for num in nums:
            if num > 0:
                res *= num
                p = True
            elif num < 0:
                res *= num
                if max_n == 0 or num > max_n:
                    max_n = num
                count += 1
            else:
                zero = True
        if count == 0 and not p:
            return 0
        if res < 0:
            if count > 1 or p:
                return res // max_n
            if zero:
                return 0
        return res

