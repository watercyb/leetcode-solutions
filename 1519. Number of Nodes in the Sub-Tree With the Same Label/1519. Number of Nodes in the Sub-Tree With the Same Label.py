#
# Problem: 1519. Number of Nodes in the Sub-Tree With the Same Label
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
# Language: python3
# Date: 2026-04-18


class Solution:
    def countSubTrees(self, n: int, edges: List[List[int]], labels: str) -> List[int]:
        links = [[] for _ in range(n)]
        for edge in edges:
            links[edge[0]].append(edge[1])
            links[edge[1]].append(edge[0])
        res = [0] * n

        def dfs(i: int, prv: int) -> List[int]:
            res_dfs = [0] * 26
            idx = ord(labels[i]) - ord("a")
            res_dfs[idx] = 1
            for idx_next in links[i]:
                if idx_next != prv:
                    re_next = dfs(idx_next, i)
                    for j in range(26):
                        res_dfs[j] += re_next[j]
            res[i] = res_dfs[idx]
            return res_dfs

        dfs(0, -1)
        return res

