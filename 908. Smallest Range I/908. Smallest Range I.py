#
# Problem: 908. Smallest Range I
# Difficulty: Easy
# Link: https://leetcode.com/problems/smallest-range-i/
# Language: python3
# Date: 2026-04-10


class Solution:
    def smallestRangeI(self, nums: List[int], k: int) -> int:
        return max(max(nums) - min(nums) - 2 * k, 0)

