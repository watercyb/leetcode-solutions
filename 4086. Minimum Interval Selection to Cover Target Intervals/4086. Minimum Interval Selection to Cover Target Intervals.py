#
# Problem: 4086. Minimum Interval Selection to Cover Target Intervals
# Difficulty: Hard
# Link: https://leetcode.com/problems/minimum-interval-selection-to-cover-target-intervals/
# Language: python3
# Date: 2026-10-19


class Solution:
    def minSelection(
        self, availableIntervals: List[List[int]], targetIntervals: List[List[int]]
    ) -> int:
        availableIntervals.sort(key=lambda x: x[0])
        targetIntervals.sort(key=lambda x: x[0])
        dq = deque()
        dq.append((0, 0))
        stp = 0
        right = 0
        i = 0
        j = 0
        i_prv = -1
        j_prv = -1
        while i < len(targetIntervals):
            if i_prv == i and j_prv == j:
                return -1
            i_prv = i
            j_prv = j
            ts = targetIntervals[i][0]
            te = targetIntervals[i][1]
            if te <= right:
                i += 1
                continue
            right_next = right
            while j < len(availableIntervals) and (availableIntervals[j][0] <= ts or availableIntervals[j][0] <= right):
                right_next = max(right_next, availableIntervals[j][1])
                j += 1
            stp += 1
            right = right_next
            if right_next >= te:
                i += 1
        return stp

