#
# Problem: 4025. Minimize the Maximum Waiting Time at Synchronized Traffic Lights
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimize-the-maximum-waiting-time-at-synchronized-traffic-lights/
# Language: python3
# Date: 2026-08-18


class Solution:
    def minPenalty(self, period: int, lights: list[int], arrivalTime: list[int]) -> int:
        light_max = max(lights)
        res = 0
        for time in arrivalTime:
            t = time % period
            if t >= light_max:
                res = max(res, period - t)
        return res

