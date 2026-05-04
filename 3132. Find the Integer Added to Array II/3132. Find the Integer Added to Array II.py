#
# Problem: 3132. Find the Integer Added to Array II
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-the-integer-added-to-array-ii/
# Language: python3
# Date: 2026-05-04


class Solution:
    def minimumAddedInteger(self, nums1: List[int], nums2: List[int]) -> int:
        nums1.sort()
        nums2.sort()

        def chk(x: int) -> bool:
            count = 0
            i = 0
            j = 0
            while i < len(nums1) and j < len(nums2):
                if nums1[i] + x != nums2[j]:
                    count += 1
                    if count > 2:
                        return False
                else:
                    j += 1
                i += 1
            return True

        res = 1000000000
        if chk(nums2[0] - nums1[0]):
            res = nums2[0] - nums1[0]
        if chk(nums2[0] - nums1[1]):
            res = min(res, nums2[0] - nums1[1])
        if chk(nums2[0] - nums1[2]):
            res = min(res, nums2[0] - nums1[2])
        return res

