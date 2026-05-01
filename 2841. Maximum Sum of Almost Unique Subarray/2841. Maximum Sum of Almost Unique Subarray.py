#
# Problem: 2841. Maximum Sum of Almost Unique Subarray
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-sum-of-almost-unique-subarray/
# Language: python3
# Date: 2026-05-01


class Solution:
    def maxSum(self, nums: List[int], m: int, k: int) -> int:
        mp = {}
        sm = 0
        res = 0
        for i in range(k):
            count = mp.get(nums[i], 0)
            if count == 0:
                m -= 1
            mp[nums[i]] = count + 1
            sm += nums[i]
        if m <= 0:
            res = sm
        for i in range(k, len(nums)):
            count = mp.get(nums[i], 0)
            if count == 0:
                m -= 1
            mp[nums[i]] = count + 1
            count = mp.get(nums[i - k], 0)
            if count == 1:
                m += 1
            mp[nums[i - k]] = count - 1
            sm += nums[i] - nums[i - k]
            if m <= 0 and sm > res:
                res = sm
        return res

