#
# Problem: 2208. Minimum Operations to Halve Array Sum
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-operations-to-halve-array-sum/
# Language: python3
# Date: 2026-04-25


class Solution:
    def halveArray(self, nums: List[int]) -> int:
        pq = [-num for num in nums]
        target = sum(nums)
        heapq.heapify(pq)
        target /= 2
        sum_num = 0
        res = 0
        while sum_num < target:
            num = heapq.heappop(pq)
            num /= 2
            sum_num -= num
            heapq.heappush(pq, num)
            res += 1
        return res

