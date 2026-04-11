#
# Problem: 1040. Moving Stones Until Consecutive II
# Difficulty: Medium
# Link: https://leetcode.com/problems/moving-stones-until-consecutive-ii/
# Language: python3
# Date: 2026-04-11


class Solution:
    def numMovesStonesII(self, stones: List[int]) -> List[int]:
        n = len(stones)
        stones.sort()
        j = 0
        min_num = 10000000
        for i in range(n):
            while stones[i] - stones[j] >= n:
                j += 1
            count = n - i + j - 1
            if count == 1 and stones[j] > stones[i] - n + 1:
                continue
            min_num = min(min_num, count)
        max_num = (
            stones[-1]
            - stones[0]
            - n
            - min(stones[1] - stones[0], stones[-1] - stones[-2])
            + 2
        )
        return [min_num, max_num]

