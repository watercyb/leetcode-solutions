#
# Problem: 2368. Reachable Nodes With Restrictions
# Difficulty: Medium
# Link: https://leetcode.com/problems/reachable-nodes-with-restrictions/
# Language: python3
# Date: 2026-04-26


class Solution:
    def reachableNodes(
        self, n: int, edges: List[List[int]], restricted: List[int]
    ) -> int:
        links = [i for i in range(n)]
        rests = [False] * n
        for idx in restricted:
            rests[idx] = True

        def find(links: List[int], i: int) -> int:
            if links[i] != i:
                links[i] = find(links, links[i])
            return links[i]

        for edge in edges:
            if not rests[edge[0]] and not rests[edge[1]]:
                a = find(links, edge[0])
                b = find(links, edge[1])
                links[a] = b
        res = 0
        target = find(links, 0)
        for idx in range(n):
            if find(links, idx) == target:
                res += 1
        return res

