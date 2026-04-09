#
# Problem: 835. Image Overlap
# Difficulty: Medium
# Link: https://leetcode.com/problems/image-overlap/
# Language: python3
# Date: 2026-04-09


class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        def chk(x: int, y: int):
            x_l = max(0, -x)
            x_r = min(len(img1), len(img1) - x)
            y_l = max(0, -y)
            y_r = min(len(img1[0]), len(img1[0]) - y)
            res = 0
            for i in range(x_l, x_r):
                i2 = i + x
                for j in range(y_l, y_r):
                    j2 = j + y
                    res += (img1[i][j] + img2[i2][j2]) // 2
            return res

        res = 0
        for i in range(-len(img1) + 1, len(img1)):
            for j in range(-len(img1[0]) + 1, len(img1[0])):
                res = max(res, chk(i, j))
        return res

