#
# Problem: 3903. Smallest Stable Index I
# Difficulty: Easy
# Link: https://leetcode.com/problems/smallest-stable-index-i/
# Language: python3
# Date: 2026-04-20


class Solution:
    def firstStableIndex(self, nums: list[int], k: int) -> int:
        maxes = []
        max_num = 0
        for num in nums:
            max_num = max(max_num, num)
            maxes.append(max_num)
        res = -1
        min_num = 10000000000
        for i in range(len(nums) - 1, -1, -1):
            min_num = min(min_num, nums[i])
            if maxes[i] - min_num <= k:
                res = i
        return res

