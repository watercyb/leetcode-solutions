#
# Problem: 1855. Maximum Distance Between a Pair of Values
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/
# Language: python3
# Date: 2026-04-21


class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        j = 0
        res = 0
        for i in range(len(nums2)):
            while j <= i and j < len(nums1) and nums1[j] > nums2[i]:
                j += 1
            if j == len(nums1):
                break
            res = max(res, i - j)
        return res

