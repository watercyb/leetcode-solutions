#
# Problem: Unknown Problem
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-cost-to-delete-array/
# Language: python3
# Date: 2026-11-28


class Solution:
    def minCost(self, nums: list[int]) -> int:
        max_val = -10000000000000000
        min_val = 10000000000000000
        sum_nums = nums[0] + nums[-1]
        count = 0
        for i in range(1, len(nums) - 1):
            if nums[i] > 0:
                min_val = min(min_val, nums[i])
            else:
                max_val = max(max_val, nums[i])
                sum_nums += nums[i]
                count += 1
        if count % 2 == 0:
            return sum_nums
        else:
            return min(sum_nums - max_val, sum_nums + min_val)

