#
# Problem: 1818. Minimum Absolute Sum Difference
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-absolute-sum-difference/
# Language: python3
# Date: 2026-04-21


class Solution:
    def minAbsoluteSumDiff(self, nums1: List[int], nums2: List[int]) -> int:
        arr = sorted(nums1)
        res = 0
        max_num = 0
        for i in range(len(nums1)):
            diff = abs(nums1[i] - nums2[i])
            res += diff
            idx = bisect_left(arr, nums2[i])
            if max_num >= diff:
                continue
            if idx > 0:
                max_num = max(max_num, diff - nums2[i] + arr[idx - 1])
            if idx < len(arr):
                max_num = max(max_num, diff - arr[idx] + nums2[i])
        return (res - max_num) % 1_000_000_007

