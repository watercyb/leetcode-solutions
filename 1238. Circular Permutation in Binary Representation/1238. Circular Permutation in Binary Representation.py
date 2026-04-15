#
# Problem: 1238. Circular Permutation in Binary Representation
# Difficulty: Medium
# Link: https://leetcode.com/problems/circular-permutation-in-binary-representation/
# Language: python3
# Date: 2026-04-15


class Solution:
    def circularPermutation(self, n: int, start: int) -> List[int]:
        return [start ^ i ^ (i >> 1) for i in range(0, 1 << n)]

