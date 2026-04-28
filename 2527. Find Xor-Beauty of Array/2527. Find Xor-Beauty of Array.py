#
# Problem: 2527. Find Xor-Beauty of Array
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-xor-beauty-of-array/
# Language: python3
# Date: 2026-04-28


class Solution:
    def xorBeauty(self, nums: List[int]) -> int:
        return reduce(xor, nums)

