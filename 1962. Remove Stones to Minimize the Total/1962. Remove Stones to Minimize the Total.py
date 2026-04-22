#
# Problem: 1962. Remove Stones to Minimize the Total
# Difficulty: Medium
# Link: https://leetcode.com/problems/remove-stones-to-minimize-the-total/
# Language: python3
# Date: 2026-04-22


class Solution:
    def minStoneSum(self, piles: List[int], k: int) -> int:
        maxheap = [-x for x in piles]
        heapq.heapify(maxheap)
        for i in range(k):
            heapq.heappush(maxheap, heapq.heappop(maxheap) // 2)
        return -sum(maxheap)

