#
# Problem: 2576. Find the Maximum Number of Marked Indices
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-the-maximum-number-of-marked-indices/
# Language: python3
# Date: 2026-04-28


class Solution:
    def maxNumOfMarkedIndices(self, nums: List[int]) -> int:
        nums.sort()
        j = len(nums) // 2
        res = 0
        for i in range(len(nums) // 2):
            while j < len(nums) and nums[j] < 2 * nums[i]:
                j += 1
            if j < len(nums):
                res += 2
                j += 1
        return res

