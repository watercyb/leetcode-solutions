#
# Problem: 1144. Decrease Elements To Make Array Zigzag
# Difficulty: Medium
# Link: https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/
# Language: python3
# Date: 2026-04-14


class Solution:
    def movesToMakeZigzag(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        count = 0
        for i in range(1, len(nums), 2):
            if i + 1 < len(nums):
                count += max(nums[i] - min(nums[i - 1], nums[i + 1]) + 1, 0)
            else:
                count += max(nums[i] - nums[i - 1] + 1, 0)
        res = count
        count = 0
        for i in range(0, len(nums), 2):
            if i > 0 and i + 1 < len(nums):
                count += max(nums[i] - min(nums[i - 1], nums[i + 1]) + 1, 0)
            elif i == 0:
                count += max(nums[i] - nums[i + 1] + 1, 0)
            else:
                count += max(nums[i] - nums[i - 1] + 1, 0)
        res = min(res, count)
        return res

