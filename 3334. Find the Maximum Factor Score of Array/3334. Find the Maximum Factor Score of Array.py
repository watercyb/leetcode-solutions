#
# Problem: 3334. Find the Maximum Factor Score of Array
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-the-maximum-factor-score-of-array/
# Language: python3
# Date: 2026-05-06


class Solution:
    def maxScore(self, nums: List[int]) -> int:
        gcds = []
        lcms = []
        gcd = 0
        lcm = 1
        for i in range(len(nums)):
            gcds.append(gcd)
            lcms.append(lcm)
            gcd = math.gcd(gcd, nums[i])
            lcm = math.lcm(lcm, nums[i])
        res = gcd * lcm
        gcd = 0
        lcm = 1
        for i in range(len(nums) - 1, -1, -1):
            res = max(res, math.gcd(gcd, gcds[i]) * math.lcm(lcm, lcms[i]))
            gcd = math.gcd(gcd, nums[i])
            lcm = math.lcm(lcm, nums[i])
        return res

