#
# Problem: 2856. Minimum Array Length After Pair Removals
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-array-length-after-pair-removals/
# Language: python3
# Date: 2026-05-01


class Solution:
    def minLengthAfterRemovals(self, nums: List[int]) -> int:
        return max(
            max(collections.Counter(nums).values()) * 2 - len(nums), len(nums) % 2
        )

