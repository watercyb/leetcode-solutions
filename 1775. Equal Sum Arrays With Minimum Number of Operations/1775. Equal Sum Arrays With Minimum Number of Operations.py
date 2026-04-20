#
# Problem: 1775. Equal Sum Arrays With Minimum Number of Operations
# Difficulty: Medium
# Link: https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/
# Language: python3
# Date: 2026-04-20


class Solution:
    def minOperations(self, nums1: List[int], nums2: List[int]) -> int:
        diff = sum(nums1) - sum(nums2)
        if diff == 0:
            return 0
        if diff > 0:
            temp = nums1
            nums1 = nums2
            nums2 = temp
        else:
            diff = -diff
        counts1 = [0] * 6
        counts2 = [0] * 6
        for num in nums1:
            counts1[num - 1] += 1
        for num in nums2:
            counts2[num - 1] += 1
        res = 0
        for i in range(6):
            diff -= (5 - i) * (counts1[i] + counts2[5 - i])
            if diff <= 0:
                return res + counts1[i] + counts2[5 - i] + int(diff / (5 - i))
            else:
                res += counts1[i] + counts2[5 - i]
        return -1

