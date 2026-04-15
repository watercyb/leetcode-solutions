#
# Problem: 3898. Find the Degree of Each Vertex
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-the-degree-of-each-vertex/
# Language: python3
# Date: 2026-04-15


class Solution:
    def findDegrees(self, matrix: list[list[int]]) -> list[int]:
        res = []
        for row in matrix:
            res.append(sum(row))
        return res

