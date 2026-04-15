#
# Problem: 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
# Language: python3
# Date: 2026-04-15


class Solution:
    def maxSideLength(self, mat: List[List[int]], threshold: int) -> int:
        sums = [[0] * (len(mat[0]) + 1) for _ in range(len(mat) + 1)]
        res = 1
        for i in range(len(mat)):
            prv = 0
            for j in range(len(mat[0])):
                prv += mat[i][j]
                sums[i + 1][j + 1] = sums[i][j + 1] + prv
                while (
                    i + 1 >= res
                    and j + 1 >= res
                    and sums[i + 1][j + 1]
                    - sums[i - res + 1][j + 1]
                    - sums[i + 1][j - res + 1]
                    + sums[i - res + 1][j - res + 1]
                    <= threshold
                ):
                    res += 1
        return res - 1

