#
# Problem: 4068. Maximize Meeting Earnings with Idle Gaps
# Difficulty: Hard
# Link: https://leetcode.com/problems/maximize-meeting-earnings-with-idle-gaps/
# Language: python3
# Date: 2026-10-21


class Solution:
    def maxEarnings(self, meetings: list[list[int]]) -> int:
        meetings.sort(key=lambda x: x[1])
        ends = []
        vals = []
        res = 0
        for start, end, revenue in meetings:
            idx = bisect_right(ends, start) - 1
            max_val = vals[idx] if idx >= 0 else -1000000000
            earn = max_val + start + revenue
            res = max(res, earn, revenue)
            val = max(revenue, earn) - end
            if len(ends) == 0 or vals[-1] < val:
                ends.append(end)
                vals.append(val)
        return res

