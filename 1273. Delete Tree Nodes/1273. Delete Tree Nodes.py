#
# Problem: 1273. Delete Tree Nodes
# Difficulty: Medium
# Link: https://leetcode.com/problems/delete-tree-nodes/
# Language: python3
# Date: 2026-04-15


class Solution:
    def deleteTreeNodes(self, nodes: int, parent: List[int], value: List[int]) -> int:
        links = [[] for _ in range(nodes)]
        for i in range(1, nodes):
            links[parent[i]].append(i)

        def dfs(i: int) -> List[int]:
            sm = value[i]
            cnt = 1
            for nxt in links[i]:
                res = dfs(nxt)
                sm += res[0]
                cnt += res[1]
            if sm == 0:
                return [0, 0]
            return [sm, cnt]

        return dfs(0)[1]

