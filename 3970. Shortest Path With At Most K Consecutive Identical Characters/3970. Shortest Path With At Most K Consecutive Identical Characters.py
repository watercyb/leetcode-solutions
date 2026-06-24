#
# Problem: 3970. Shortest Path With At Most K Consecutive Identical Characters
# Difficulty: Medium
# Link: https://leetcode.com/problems/shortest-path-with-at-most-k-consecutive-identical-characters/
# Language: python3
# Date: 2026-06-24


class Solution:
    def shortestPath(self, n: int, edges: List[List[int]], labels: str, k: int) -> int:
        links = [[] for _ in range(0, n)]
        for edge in edges:
            links[edge[0]].append([edge[1], edge[2]])
        lens = [k + 1] * n
        pq = []
        heapq.heappush(pq, [0, 0, 1])  # weight, idx, len
        while len(pq) > 0:
            current = heapq.heappop(pq)
            w = current[0]
            idx = current[1]
            l = current[2]
            if idx == n - 1:
                return w
            if lens[idx] <= l:
                continue
            lens[idx] = l
            char = labels[idx]
            for next_node in links[idx]:
                next_idx = next_node[0]
                next_w = w + next_node[1]
                next_char = labels[next_idx]
                if next_char != char:
                    next_l = 1
                else:
                    next_l = l + 1
                if next_l <= k:
                    heapq.heappush(pq, [next_w, next_idx, next_l])
        return -1

