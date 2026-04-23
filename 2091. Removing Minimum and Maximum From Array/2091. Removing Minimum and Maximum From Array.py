#
# Problem: 2091. Removing Minimum and Maximum From Array
# Difficulty: Medium
# Link: https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
# Language: python3
# Date: 2026-04-23


class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        max_idx = nums.index(max(nums))
        min_idx = nums.index(min(nums))
        left = min(min_idx, max_idx)
        right = max(min_idx, max_idx)
        return len(nums) - max(left, right - left - 1, len(nums) - right - 1)

