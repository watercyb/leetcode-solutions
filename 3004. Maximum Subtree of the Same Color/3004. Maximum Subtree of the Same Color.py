#
# Problem: 3004. Maximum Subtree of the Same Color
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-subtree-of-the-same-color/
# Language: python3
# Date: 2026-05-03


class Solution:
    def maximumSubtreeSize(self, edges: List[List[int]], colors: List[int]) -> int:
        links = [[] for _ in range(len(colors))]
        for edge in edges:
            links[edge[0]].append(edge[1])
            links[edge[1]].append(edge[0])
        res = 0

        def dfs(i: int, prv: int) -> [int, int]:
            nonlocal res
            color = colors[i]
            cnt = 1
            for nxt in links[i]:
                if nxt == prv:
                    continue
                res_next = dfs(nxt, i)
                if res_next[0] != color:
                    color = -1
                cnt += res_next[1]
            if color != -1 and cnt > res:
                res = cnt
            return [color, cnt]

        dfs(0, -1)
        return res

