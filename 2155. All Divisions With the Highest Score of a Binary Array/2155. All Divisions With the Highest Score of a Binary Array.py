#
# Problem: 2155. All Divisions With the Highest Score of a Binary Array
# Difficulty: Medium
# Link: https://leetcode.com/problems/all-divisions-with-the-highest-score-of-a-binary-array/
# Language: python3
# Date: 2026-04-24


class Solution:
    def maxScoreIndices(self, nums: List[int]) -> List[int]:
        num_sum = 0
        for num in nums:
            num_sum += num
        res = [0]
        max_sum = num_sum
        for i in range(len(nums)):
            num_sum += 1 - nums[i] * 2
            if num_sum == max_sum:
                res.append(i + 1)
            elif num_sum > max_sum:
                max_sum = num_sum
                res = [i + 1]
        return res

