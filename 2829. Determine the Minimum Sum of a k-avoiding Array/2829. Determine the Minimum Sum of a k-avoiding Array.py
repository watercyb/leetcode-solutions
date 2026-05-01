#
# Problem: 2829. Determine the Minimum Sum of a k-avoiding Array
# Difficulty: Medium
# Link: https://leetcode.com/problems/determine-the-minimum-sum-of-a-k-avoiding-array/
# Language: python3
# Date: 2026-05-01


class Solution:
    def minimumSum(self, n: int, k: int) -> int:
        nums = set()
        num = 1
        while len(nums) < n:
            if k - num not in nums:
                nums.add(num)
            num += 1
        return sum(nums)

