#
# Problem: 2925. Maximum Score After Applying Operations on a Tree
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-score-after-applying-operations-on-a-tree/
# Language: python3
# Date: 2026-05-02


class Solution:
    def maximumScoreAfterOperations(
        self, edges: List[List[int]], values: List[int]
    ) -> int:
        links = [[] for _ in range(len(edges) + 1)]

        for i in range(len(edges)):
            links[edges[i][0]].append(edges[i][1])
            links[edges[i][1]].append(edges[i][0])

        def dfs(i: int, prv: int) -> List[int]:
            if i != 0 and len(links[i]) == 1:
                return [0, values[i]]
            a = 0
            b = 0
            for nxt in links[i]:
                if nxt == prv:
                    continue
                res = dfs(nxt, i)
                a += res[0]
                b += max(res[0], res[1])
            return [max(a + values[i], b), b + values[i]]

        return dfs(0, -1)[0]

