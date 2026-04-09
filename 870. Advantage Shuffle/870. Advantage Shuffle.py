#
# Problem: 870. Advantage Shuffle
# Difficulty: Medium
# Link: https://leetcode.com/problems/advantage-shuffle/
# Language: python3
# Date: 2026-04-09


class Solution:
    def advantageCount(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        arr = []
        for i in range(len(nums2)):
            arr.append([nums2[i], i])
        arr.sort()
        idx = len(nums1) - 1
        res = [-1] * len(nums1)
        for i in range(len(nums2) - 1, -1, -1):
            if arr[i][0] < nums1[idx]:
                res[arr[i][1]] = nums1[idx]
                arr[i][0] = -1
                idx -= 1
        for i in range(len(nums2) - 1, -1, -1):
            if arr[i][0] != -1:
                res[arr[i][1]] = nums1[idx]
                idx -= 1
        return res

