#
# Problem: 2811. Check if it is Possible to Split Array
# Difficulty: Medium
# Link: https://leetcode.com/problems/check-if-it-is-possible-to-split-array/
# Language: python3
# Date: 2026-05-01


class Solution:
    def canSplitArray(self, nums: List[int], m: int) -> bool:
        if len(nums) <= 2:
            return True
        for i in range(1, len(nums)):
            if nums[i] + nums[i - 1] >= m:
                return True
        return False

