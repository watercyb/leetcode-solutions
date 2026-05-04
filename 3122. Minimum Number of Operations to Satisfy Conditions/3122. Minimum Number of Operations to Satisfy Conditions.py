#
# Problem: 3122. Minimum Number of Operations to Satisfy Conditions
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-number-of-operations-to-satisfy-conditions/
# Language: python3
# Date: 2026-05-04


class Solution:
    def minimumOperations(self, grid: List[List[int]]) -> int:
        min1 = 0
        min1_num = -1
        min2 = 0
        for i in range(len(grid[0])):
            counts = [0] * 10
            for j in range(len(grid)):
                counts[grid[j][i]] += 1
            min1_next = 10000000
            min1_num_next = 0
            min2_next = 10000000
            for j in range(10):
                if j != min1_num:
                    op = len(grid) - counts[j] + min1
                    if op < min1_next:
                        min1_num_next = j
                        min2_next = min1_next
                        min1_next = op
                    elif op < min2_next:
                        min2_next = op
                else:
                    op = len(grid) - counts[j] + min2
                    if op < min1_next:
                        min1_num_next = j
                        min2_next = min1_next
                        min1_next = op
                    elif op < min2_next:
                        min2_next = op
            min1 = min1_next
            min1_num = min1_num_next
            min2 = min2_next
        return min1

