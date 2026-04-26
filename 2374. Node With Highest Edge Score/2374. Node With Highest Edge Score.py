#
# Problem: 2374. Node With Highest Edge Score
# Difficulty: Medium
# Link: https://leetcode.com/problems/node-with-highest-edge-score/
# Language: python3
# Date: 2026-04-26


class Solution:
    def edgeScore(self, edges: List[int]) -> int:
        scores = [0] * len(edges)
        for i in range(len(edges)):
            scores[edges[i]] += i
        res = 0
        for i in range(len(scores)):
            if scores[i] > scores[res]:
                res = i
        return res

