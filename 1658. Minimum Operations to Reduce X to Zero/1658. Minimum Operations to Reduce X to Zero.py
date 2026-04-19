#
# Problem: 1658. Minimum Operations to Reduce X to Zero
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
# Language: python3
# Date: 2026-04-19


class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        total = sum(nums)
        if total < x:
            return -1
        if total == x:
            return len(nums)
        i = 0
        j = 0
        res = len(nums)
        while i < len(nums) or (j == len(nums) and total < x):
            while j < len(nums) and total > x:
                total -= nums[j]
                j += 1
            if total == x and len(nums) - j + i < res:
                res = len(nums) - j + i
            total += nums[i]
            i += 1
        if res == len(nums):
            return -1
        return res

