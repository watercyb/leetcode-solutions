#
# Problem: 1296. Divide Array in Sets of K Consecutive Numbers
# Difficulty: Medium
# Link: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
# Language: python3
# Date: 2026-04-15


class Solution:
    def isPossibleDivide(self, nums: List[int], k: int) -> bool:
        nums.sort()
        pq = []
        heapify(pq)
        num = 0
        count = 0
        idx = 0
        while idx < len(nums):
            if len(pq) > 0 and pq[0][0] == num:
                count -= pq[0][1]
                heappop(pq)
            if num < nums[idx]:
                if count > 0:
                    return False
                num = nums[idx]
            else:
                count_current = 0
                while idx < len(nums) and nums[idx] == num:
                    count_current += 1
                    idx += 1
                if count_current < count:
                    return False
                elif count_current > count:
                    diff = count_current - count
                    count = count_current
                    heappush(pq, [num + k, diff])
                num += 1
        if len(pq) > 0 and pq[0][0] == num:
            count -= pq[0][1]
            heappop(pq)
        return count == 0

