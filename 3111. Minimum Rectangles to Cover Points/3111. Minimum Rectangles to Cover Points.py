#
# Problem: 3111. Minimum Rectangles to Cover Points
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-rectangles-to-cover-points/?envType=problem-list-v2&envId=greedy
# Language: python3
# Date: 2026-04-06


class Solution:
    def minRectanglesToCoverPoints(self, points: List[List[int]], w: int) -> int:
        points.sort(key=lambda x: x[0])
        res = 0
        prv = -w - 1
        for point in points:
            if point[0] - prv > w:
                res += 1
                prv = point[0]
        return res

