#
# Problem: 795. Number of Subarrays with Bounded Maximum
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
# Language: python3
# Date: 2026-04-08


class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        len1 = 0
        len2 = 0
        res = 0
        for num in nums:
            if num <= right:
                len1 += 1
            else:
                len1 = 0
            if num < left:
                len2 += 1
            else:
                len2 = 0
            res += len1 - len2
        return res

