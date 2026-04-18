#
# Problem: 1558. Minimum Numbers of Function Calls to Make Target Array
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/
# Language: python3
# Date: 2026-04-18


class Solution:
    def minOperations(self, nums: List[int]) -> int:
        res = max(max(nums).bit_length() - 1, 0)
        for num in nums:
            res += num.bit_count()
        return res

