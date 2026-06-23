#
# Problem: 3965. Finish Time of Tasks I
# Difficulty: Medium
# Link: https://leetcode.com/problems/finish-time-of-tasks-i/
# Language: python3
# Date: 2026-06-23


class Solution:
    def finishTime(self, n: int, edges: List[List[int]], baseTime: List[int]) -> int:
        if n == 1:
            return baseTime[0]
        links = [[] for _ in range(0, n)]
        for edge in edges:
            links[edge[0]].append(edge[1])
            links[edge[1]].append(edge[0])

        def dfs(links: List[List[int]], baseTime: List[int], i: int, prv: int) -> int:
            if prv != -1 and len(links[i]) == 1:
                return baseTime[i]
            else:
                max_val = 0
                min_val = 100000000000000
                for next in links[i]:
                    if next != prv:
                        res = dfs(links, baseTime, next, i)
                        max_val = max(max_val, res)
                        min_val = min(min_val, res)
                return 2 * max_val - min_val + baseTime[i]

        return dfs(links, baseTime, 0, -1)

