#
# Problem: 2077. Paths in Maze That Lead to Same Room
# Difficulty: Medium
# Link: https://leetcode.com/problems/paths-in-maze-that-lead-to-same-room/
# Language: python3
# Date: 2026-04-23


class Solution:
    def numberOfPaths(self, n: int, corridors: List[List[int]]) -> int:
        links = [set() for _ in range(n)]
        for corridor in corridors:
            a = corridor[0] - 1
            b = corridor[1] - 1
            links[a].add(b)
            links[b].add(a)
        res = 0
        for corridor in corridors:
            a = corridor[0] - 1
            b = corridor[1] - 1
            for val in links[a]:
                if val in links[b]:
                    res += 1
        return res//3

