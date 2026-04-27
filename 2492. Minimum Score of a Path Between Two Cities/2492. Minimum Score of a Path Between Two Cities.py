#
# Problem: 2492. Minimum Score of a Path Between Two Cities
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
# Language: python3
# Date: 2026-04-27


class Solution:
    def minScore(self, n: int, roads: List[List[int]]) -> int:
        links = [i for i in range(n)]

        def find(links: List[int], i: int) -> int:
            if links[i] != i:
                links[i] = find(links, links[i])
            return links[i]

        min_values = [100000] * n
        for road in roads:
            v1 = road[0] - 1
            v2 = road[1] - 1
            a = find(links, v1)
            b = find(links, v2)
            min_values[v1] = min(road[2], min_values[v1])
            links[a] = b

        target = find(links, 0)
        res = 100000
        for i in range(n):
            if find(links, i) == target and min_values[i] < res:
                res = min_values[i]
        return res

