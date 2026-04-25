#
# Problem: 2250. Count Number of Rectangles Containing Each Point
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-number-of-rectangles-containing-each-point/
# Language: python3
# Date: 2026-04-25


class Solution:
    def countRectangles(
        self, rectangles: List[List[int]], points: List[List[int]]
    ) -> List[int]:
        arr = []
        rectangles.sort(key=lambda x: -x[0])
        p = []
        for i in range(len(points)):
            p.append((points[i][0], points[i][1], i))
        p.sort(key=lambda x: -x[0])
        res = [0] * len(points)
        idx = 0
        for pair in p:
            x = pair[0]
            y = pair[1]
            id = pair[2]
            while idx < len(rectangles) and rectangles[idx][0] >= x:
                bisect.insort(arr, rectangles[idx][1])
                idx += 1
            res[id] = len(arr) - bisect_left(arr, y)
        return res

