#
# Problem: 2587. Rearrange Array to Maximize Prefix Score
# Difficulty: Medium
# Link: https://leetcode.com/problems/rearrange-array-to-maximize-prefix-score/
# Language: python3
# Date: 2026-04-28


class Solution:
    def maxScore(self, nums: List[int]) -> int:
        nums.sort()
        sum = 0
        for i in range(len(nums) - 1, -1, -1):
            sum += nums[i]
            if sum <= 0:
                return len(nums) - 1 - i
        return len(nums)

