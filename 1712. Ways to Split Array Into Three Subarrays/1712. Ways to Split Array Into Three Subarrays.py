#
# Problem: 1712. Ways to Split Array Into Three Subarrays
# Difficulty: Medium
# Link: https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/
# Language: python3
# Date: 2026-04-20


class Solution:
    def waysToSplit(self, nums: List[int]) -> int:
        sm = sum(nums)
        i = 0
        j = 0
        k = 0
        sm1 = 0
        sm2 = 0
        sm3 = 0
        res = 0
        while i < len(nums):
            sm1 += nums[i]
            while (j < len(nums) and sm2 + nums[j] < 2 * sm1) or j <= i:
                sm2 += nums[j]
                j += 1
            while k < len(nums) and sm + sm1 - sm3 >= 2 * nums[k]:
                sm -= nums[k]
                sm3 += nums[k]
                k += 1
            if k < j or j == len(nums):
                break
            res += k - j
            if k == len(nums):
                res -= 1
            i += 1
        return res % 1_000_000_007

