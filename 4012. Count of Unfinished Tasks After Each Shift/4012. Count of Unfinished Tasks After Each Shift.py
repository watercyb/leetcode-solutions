#
# Problem: 4012. Count of Unfinished Tasks After Each Shift
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-of-unfinished-tasks-after-each-shift/
# Language: python3
# Date: 2026-08-06


class Solution:
    def countTasks(self, tasks: List[int], shifts: List[int]) -> List[int]:
        sums = [0]
        for task in tasks:
            sums.append(sums[-1] + task)
        time_sum = 0
        res = []
        for shift in shifts:
            time_sum += shift
            idx = bisect.bisect_right(sums, time_sum)
            res.append(len(sums) - idx)
            if idx == len(sums):
                time_sum = 0
        return res

