#
# Problem: 1997. First Day Where You Have Been in All the Rooms
# Difficulty: Medium
# Link: https://leetcode.com/problems/first-day-where-you-have-been-in-all-the-rooms/
# Language: python3
# Date: 2026-04-22


class Solution:
    def firstDayBeenInAllRooms(self, nextVisit: List[int]) -> int:
        mod = 1_000_000_007
        dp = [0]
        for i in range(len(nextVisit) - 1):
            dp.append((dp[i] + dp[i] - dp[nextVisit[i]] + mod + 2) % mod)
        return dp[-1]

