#
# Problem: 3275. K-th Nearest Obstacle Queries
# Difficulty: Medium
# Link: https://leetcode.com/problems/k-th-nearest-obstacle-queries/
# Language: python3
# Date: 2026-05-05


class Solution:
    def resultsArray(self, queries: List[List[int]], k: int) -> List[int]:
        pq = []
        heapq.heapify(pq)
        res = []
        for query in queries:
            dist = abs(query[0]) + abs(query[1])
            heapq.heappush(pq, -dist)
            if len(pq) < k:
                res.append(-1)
            elif len(pq) == k:
                res.append(-pq[0])
            else:
                heapq.heappop(pq)
                res.append(-pq[0])
        return res

