#
# Problem: 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
# Language: python3
# Date: 2026-04-17


class Solution:
    def maxArea(
        self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]
    ) -> int:
        horizontalCuts.sort()
        verticalCuts.sort()
        horizontalCuts.append(h)
        verticalCuts.append(w)
        prv_x = 0
        max_x = 0
        for x in horizontalCuts:
            max_x = max(max_x, x - prv_x)
            prv_x = x

        prv_y = 0
        max_y = 0
        for y in verticalCuts:
            max_y = max(max_y, y - prv_y)
            prv_y = y
        return max_x * max_y % 1_000_000_007

