#
# Problem: 2378. Choose Edges to Maximize Score in a Tree
# Difficulty: Medium
# Link: https://leetcode.com/problems/choose-edges-to-maximize-score-in-a-tree/
# Language: python3
# Date: 2026-04-26


class Solution:
    def maxScore(self, edges: List[List[int]]) -> int:
        links = [[] for _ in range(len(edges))]
        for i in range(1, len(edges)):
            links[edges[i][0]].append([i, edges[i][1]])

        def dfs(i: int) -> int:
            sm = 0
            mx = 0
            for nxt in links[i]:
                res = dfs(nxt[0])
                sm += res[1]
                mx = max(mx, res[0] + nxt[1] - res[1])
            return [sm, sm + mx]

        res = dfs(0)

        return max(res[0], res[1])

