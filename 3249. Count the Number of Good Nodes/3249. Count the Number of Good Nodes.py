#
# Problem: 3249. Count the Number of Good Nodes
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-the-number-of-good-nodes/
# Language: python3
# Date: 2026-05-05


class Solution:
    def countGoodNodes(self, edges: List[List[int]]) -> int:
        links = [[] for _ in range(len(edges) + 1)]
        for edge in edges:
            links[edge[0]].append(edge[1])
            links[edge[1]].append(edge[0])
        res = 0

        def dfs(i: int, prv: int) -> int:
            nonlocal res
            sm = 0
            count = 0
            isGood = True
            for nxt in links[i]:
                if nxt == prv:
                    continue
                count_next = dfs(nxt, i)
                if count == 0 or count == count_next:
                    count = count_next
                else:
                    isGood = False
                sm += count_next
            if isGood:
                res += 1
            return sm+1

        dfs(0, -1)
        return res

