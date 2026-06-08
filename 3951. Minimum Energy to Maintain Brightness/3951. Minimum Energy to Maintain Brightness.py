#
# Problem: 3951. Minimum Energy to Maintain Brightness
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-energy-to-maintain-brightness/
# Language: python3
# Date: 2026-06-08


class Solution:
    def minEnergy(self, n: int, brightness: int, intervals: list[list[int]]) -> int:
        count = (brightness + 2) // 3
        intervals.sort(key=lambda x: x[0])
        lim = -1
        res = 0
        for interval in intervals:
            res += max(interval[1] - max(lim, interval[0] - 1), 0) * count
            lim = max(lim, interval[1])
        return res

