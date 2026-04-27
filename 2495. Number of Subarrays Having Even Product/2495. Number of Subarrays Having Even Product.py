#
# Problem: 2495. Number of Subarrays Having Even Product
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-subarrays-having-even-product/
# Language: python3
# Date: 2026-04-27


class Solution:
    def evenProduct(self, nums: List[int]) -> int:
        length = 0
        res = (len(nums) + 1) * len(nums) // 2
        for num in nums:
            if (num & 1) == 0:
                res -= (length + 1) * length // 2
                length = 0
            else:
                length += 1
        res -= (length + 1) * length // 2
        return res

