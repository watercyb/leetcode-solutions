#
# Problem: 469. Convex Polygon
# Difficulty: Medium
# Link: https://leetcode.com/problems/convex-polygon/
# Language: python3
# Date: 2026-04-03


class Solution:
    def isConvex(self, points: List[List[int]]) -> bool:
        def chk(i: int, j: int, k: int) -> int:
            a = (points[k][0] - points[j][0]) * (points[i][1] - points[j][1]) - (
                points[k][1] - points[j][1]
            ) * (points[i][0] - points[j][0])
            if a == 0:
                return 0
            elif a > 0:
                return 1
            else:
                return -1

        a = chk(-2, -1, 0)
        for i in range(len(points) - 1):
            b = chk(i - 1, i, i + 1)
            if a == 0:
                a = b
            elif b == 0:
                continue
            elif a * b != 1:
                return False
        return True

