#
# Problem: 3618. Split Array by Prime Indices
# Difficulty: Medium
# Link: https://leetcode.com/problems/split-array-by-prime-indices/
# Language: python3
# Date: 2026-05-09


class Solution:
    def splitArray(self, nums: List[int]) -> int:
        res = 0
        if len(nums) <= 2:
            for i in range(len(nums)):
                res += nums[i]
            return abs(res)
        nonPrimes = [False] * len(nums)
        nonPrimes[0] = True
        nonPrimes[1] = True
        for i in range(len(nums)):
            if nonPrimes[i]:
                res += nums[i]
                continue
            res -= nums[i]
            for j in range(i * i, len(nums), i):
                nonPrimes[j] = True
        return abs(res)

