#
# Problem: 667. Beautiful Arrangement II
# Difficulty: Medium
# Link: https://leetcode.com/problems/beautiful-arrangement-ii/
# Language: python3
# Date: 2026-04-06


class Solution:
    def constructArray(self, n: int, k: int) -> List[int]:
        left = 1
        right = k + 1
        res = []
        while left < right:
            res.append(left)
            res.append(right)
            left += 1
            right -= 1
        if left == right:
            res.append(left)
        res.extend(range(k + 2, n + 1))
        return res

