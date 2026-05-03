#
# Problem: 3002. Maximum Size of a Set After Removals
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-size-of-a-set-after-removals/
# Language: python3
# Date: 2026-05-03


class Solution:
    def maximumSetSize(self, nums1: List[int], nums2: List[int]) -> int:
        st = set(nums1)
        st.update(nums2)
        return min(
            len(st),
            (
                min(len(nums1) // 2, len(set(nums1)))
                + min(len(nums2) // 2, len(set(nums2)))
            ),
        )

