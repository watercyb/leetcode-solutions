#
# Problem: 4068. Maximize Meeting Earnings with Idle Gaps
# Difficulty: Hard
# Link: https://leetcode.com/problems/maximize-meeting-earnings-with-idle-gaps/
# Language: python3
# Date: 2026-09-28


class Solution:
    def maxEarnings(self, meetings: list[list[int]]) -> int:
        meetings.sort(key=lambda x: x[0])
        pq = []
        res = 0
        max_val = -1000000000
        for meeting in meetings:
            start = meeting[0]
            end = meeting[1]
            revenue = meeting[2]
            res = max(res, revenue)
            while len(pq) > 0 and pq[0][0] <= start:
                max_val = max(max_val, heapq.heappop(pq)[1])
            earn = max_val + start + revenue
            res = max(res, earn)
            heapq.heappush(pq, (end, max(revenue, earn) - end))
        return res

