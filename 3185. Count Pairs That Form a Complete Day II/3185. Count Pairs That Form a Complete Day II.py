#
# Problem: 3185. Count Pairs That Form a Complete Day II
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-pairs-that-form-a-complete-day-ii/
# Language: python3
# Date: 2026-05-04


class Solution:
    def countCompleteDayPairs(self, hours: List[int]) -> int:
        counts = [0] * 24
        res = 0
        for hour in hours:
            hour = hour % 24
            res += counts[(24 - hour) % 24]
            counts[hour] += 1
        return res

