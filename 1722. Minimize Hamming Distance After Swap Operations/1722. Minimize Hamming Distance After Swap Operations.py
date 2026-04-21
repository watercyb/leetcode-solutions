#
# Problem: 1722. Minimize Hamming Distance After Swap Operations
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/?envType=daily-question&envId=2026-04-21
# Language: python3
# Date: 2026-04-21


class Solution:
    def minimumHammingDistance(
        self, source: List[int], target: List[int], allowedSwaps: List[List[int]]
    ) -> int:
        def find(links: List[int], i: int) -> int:
            if links[i] != i:
                links[i] = find(links, links[i])
            return links[i]

        n = len(source)
        links = [i for i in range(n)]
        for edge in allowedSwaps:
            a = find(links, edge[0])
            b = find(links, edge[1])
            links[a] = b
        mps = [None] * n
        for i in range(n):
            a = find(links, i)
            if mps[a] is None:
                mps[a] = {}
                mps[a][source[i]] = 1
            else:
                mps[a][source[i]] = mps[a].get(source[i], 0) + 1
        res = 0
        for i in range(n):
            if mps[links[i]].get(target[i], 0) == 0:
                res += 1
            else:
                mps[links[i]][target[i]] -= 1
        return res

