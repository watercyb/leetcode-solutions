#
# Problem: 3282. Reach End of Array With Max Score
# Difficulty: Medium
# Link: https://leetcode.com/problems/reach-end-of-array-with-max-score/
# Language: python3
# Date: 2026-05-05


class Solution:
    def findMaximumScore(self, nums: List[int]) -> int:
        idx = 0
        max_num = nums[0]
        res = 0
        for i in range(1, len(nums) - 1):
            if nums[i] > max_num:
                res += (i - idx) * max_num
                idx = i
                max_num = nums[i]
        res += (len(nums) - 1 - idx) * max_num
        return res

