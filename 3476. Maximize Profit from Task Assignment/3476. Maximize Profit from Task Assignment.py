#
# Problem: 3476. Maximize Profit from Task Assignment
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximize-profit-from-task-assignment/
# Language: python3
# Date: 2026-05-07


class Solution:
    def maxProfit(self, workers: List[int], tasks: List[List[int]]) -> int:
        counts = {}
        for num in workers:
            counts[num] = counts.get(num, 0) + 1
        tasks.sort(key=lambda x: -x[1])
        max_num = 0
        res = 0
        for skill, earn in tasks:
            if counts.get(skill, 0) > 0:
                counts[skill] -= 1
                res += earn
            elif max_num == 0:
                max_num = earn
        return res + max_num

