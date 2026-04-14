#
# Problem: 1109. Corporate Flight Bookings
# Difficulty: Medium
# Link: https://leetcode.com/problems/corporate-flight-bookings/
# Language: python3
# Date: 2026-04-14


class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        arr = [0] * (n + 1)
        for booking in bookings:
            arr[booking[0] - 1] += booking[2]
            arr[booking[1]] -= booking[2]
        res = []
        sum_num = 0
        for i in range(n):
            sum_num += arr[i]
            res.append(sum_num)
        return res

