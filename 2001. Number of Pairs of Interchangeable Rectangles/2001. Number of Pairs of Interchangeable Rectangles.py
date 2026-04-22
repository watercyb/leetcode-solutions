#
# Problem: 2001. Number of Pairs of Interchangeable Rectangles
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/
# Language: python3
# Date: 2026-04-22


class Solution:
    def interchangeableRectangles(self, rectangles: List[List[int]]) -> int:
        mp = {}
        res = 0
        for w, h in rectangles:
            r = w / h
            count = mp.get(r, 0)
            res += count
            mp[r] = count + 1
        return res

