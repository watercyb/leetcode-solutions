#
# Problem: 2826. Sorting Three Groups
# Difficulty: Medium
# Link: https://leetcode.com/problems/sorting-three-groups/
# Language: python3
# Date: 2026-05-01


class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        a = 0
        b = 0
        c = 0
        for num in nums:
            if num == 1:
                c += 1
                b += 1
            elif num == 2:
                c += 1
                b = min(b, a)
                a += 1
            else:
                c = min(c, a, b)
                b += 1
                a += 1
        return min(a, b, c)

