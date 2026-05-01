#
# Problem: 2860. Happy Students
# Difficulty: Medium
# Link: https://leetcode.com/problems/happy-students/
# Language: python3
# Date: 2026-05-01


class Solution:
    def countWays(self, nums: List[int]) -> int:
        nums.sort()
        nums.append(10**9)
        res = 0
        sm = 0
        isGood = True
        for i in range(len(nums)):
            if isGood and sm < nums[i]:
                res += 1
            sm += 1
            isGood = sm > nums[i]
        return res

