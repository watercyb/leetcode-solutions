#
# Problem: 2740. Find the Value of the Partition
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-the-value-of-the-partition/
# Language: python3
# Date: 2026-08-26


class Solution:
    def findValueOfPartition(self, nums: List[int]) -> int:
        nums.sort()
        res = 1000000000
        for i in range(1, len(nums)):
            res = min(res, nums[i] - nums[i - 1])
        return res

