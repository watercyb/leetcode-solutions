#
# Problem: 3073. Maximum Increasing Triplet Value
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-increasing-triplet-value/
# Language: python3
# Date: 2026-05-03


class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        right_max = [0] * len(nums)
        max_num = 0
        for i in range(len(nums) - 1, -1, -1):
            right_max[i] = max_num
            max_num = max(max_num, nums[i])
        ss = SortedSet()
        res = 0
        for i in range(len(nums)):
            idx = ss.bisect_left(nums[i]) - 1
            if idx >= 0 and right_max[i] > nums[i]:
                res = max(res, ss[idx] + right_max[i] - nums[i])
            ss.add(nums[i])
        return res

