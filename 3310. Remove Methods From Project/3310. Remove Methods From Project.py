#
# Problem: 3310. Remove Methods From Project
# Difficulty: Medium
# Link: https://leetcode.com/problems/remove-methods-from-project/
# Language: python3
# Date: 2026-05-06


class Solution:
    def remainingMethods(
        self, n: int, k: int, invocations: List[List[int]]
    ) -> List[int]:
        links = [[] for _ in range(n)]
        for invocation in invocations:
            links[invocation[0]].append(invocation[1])
        seens = [False] * n

        def dfs(i: int):
            seens[i] = True
            for nxt in links[i]:
                if not seens[nxt]:
                    dfs(nxt)

        dfs(k)
        for i in range(n):
            if seens[i]:
                continue
            for nxt in links[i]:
                if seens[nxt]:
                    return [i for i in range(n)]
        res = []
        for i in range(n):
            if not seens[i]:
                res.append(i)
        return res

