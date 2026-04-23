#
# Problem: 2039. The Time When the Network Becomes Idle
# Difficulty: Medium
# Link: https://leetcode.com/problems/the-time-when-the-network-becomes-idle/
# Language: python3
# Date: 2026-04-23


class Solution:
    def networkBecomesIdle(self, edges: List[List[int]], patience: List[int]) -> int:
        links = [[] for _ in range(len(patience))]
        for edge in edges:
            links[edge[0]].append(edge[1])
            links[edge[1]].append(edge[0])
        patience[0] = 1
        dq = deque()
        dq.append(0)
        seens = [False] * len(patience)
        seens[0] = True
        stp = 0
        res = 0
        while len(dq) > 0:
            lim = len(dq)
            for _ in range(lim):
                current = dq.popleft()
                res = max(res, (stp - 1) // patience[current] * patience[current] + stp)
                for nxt in links[current]:
                    if not seens[nxt]:
                        seens[nxt] = True
                        dq.append(nxt)
            stp += 2
        return res + 1

