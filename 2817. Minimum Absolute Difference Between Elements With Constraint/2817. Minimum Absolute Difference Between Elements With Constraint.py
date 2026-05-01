#
# Problem: 2817. Minimum Absolute Difference Between Elements With Constraint
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/
# Language: python3
# Date: 2026-05-01


class Solution:
    def minAbsoluteDifference(self, nums: List[int], x: int) -> int:
        j = 0
        arr = []
        res = 10000000000
        for i in range(x, len(nums)):
            insort(arr, nums[j])
            idx = bisect_right(arr, nums[i])
            if idx > 0:
                res = min(res, nums[i] - arr[idx - 1])
            if idx < len(arr):
                res = min(res, arr[idx] - nums[i])
            j += 1
        return res

