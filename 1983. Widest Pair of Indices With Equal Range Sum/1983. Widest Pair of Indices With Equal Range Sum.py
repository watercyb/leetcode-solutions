#
# Problem: 1983. Widest Pair of Indices With Equal Range Sum
# Difficulty: Medium
# Link: https://leetcode.com/problems/widest-pair-of-indices-with-equal-range-sum/
# Language: python3
# Date: 2026-04-22


class Solution:
    def widestPairOfIndices(self, nums1: List[int], nums2: List[int]) -> int:
        mp = {0: -1}
        res = 0
        sm1 = 0
        sm2 = 0
        for i in range(0, len(nums1)):
            sm1 += nums1[i]
            sm2 += nums2[i]
            diff = sm1 - sm2
            if diff in mp:
                res = max(res, i - mp[diff])
            else:
                mp[diff] = i
        return res

