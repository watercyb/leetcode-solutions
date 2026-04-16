#
# Problem: 1376. Time Needed to Inform All Employees
# Difficulty: Medium
# Link: https://leetcode.com/problems/time-needed-to-inform-all-employees/
# Language: python3
# Date: 2026-04-16


class Solution:

    def numOfMinutes(
        self, n: int, headID: int, manager: List[int], informTime: List[int]
    ) -> int:
        links = [[] for _ in range(n)]
        for i in range(len(manager)):
            if i != headID:
                links[manager[i]].append(i)

        def dfs(i: int) -> int:
            res = 0
            for next in links[i]:
                res = max(dfs(next) + informTime[i], res)
            return res

        return dfs(headID)

