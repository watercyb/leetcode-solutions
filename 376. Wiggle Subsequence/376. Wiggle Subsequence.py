#
# Problem: 376. Wiggle Subsequence
# Difficulty: Medium
# Link: https://leetcode.com/problems/wiggle-subsequence/
# Language: python3
# Date: 2026-04-03


class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        len1 = 1
        len2 = 1
        prv = nums[0]
        for i in range(1, len(nums)):
            if nums[i] > prv:
                len2 = len1 + 1
            if nums[i] < prv:
                len1 = len2 + 1
            prv = nums[i]
        return max(len1, len2)

