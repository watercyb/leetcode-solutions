#
# Problem: 1911. Maximum Alternating Subsequence Sum
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-alternating-subsequence-sum/
# Language: python3
# Date: 2026-04-22


class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        even = -10000000
        odd = 0
        for num in nums:
            temp = max(even, odd + num)
            odd = max(odd, even - num)
            even = temp
        return max(even, odd)

