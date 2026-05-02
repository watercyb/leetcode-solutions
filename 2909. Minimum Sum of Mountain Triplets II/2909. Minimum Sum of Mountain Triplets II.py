#
# Problem: 2909. Minimum Sum of Mountain Triplets II
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-sum-of-mountain-triplets-ii/
# Language: python3
# Date: 2026-05-02


class Solution:
    def minimumSum(self, nums: List[int]) -> int:
        lefts = []
        min_num = 1000000000
        for num in nums:
            lefts.append(min_num)
            min_num = min(min_num, num)
        min_num = 1000000000
        res = 1000000000
        print(lefts)
        for i in range(len(nums) - 1, -1, -1):
            if nums[i] > lefts[i] and nums[i] > min_num:
                res = min(res, lefts[i] + nums[i] + min_num)
            min_num = min(min_num, nums[i])
        if res == 1000000000:
            return -1
        return res

