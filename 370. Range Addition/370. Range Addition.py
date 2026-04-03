#
# Problem: 370. Range Addition
# Difficulty: Medium
# Link: https://leetcode.com/problems/range-addition/
# Language: python3
# Date: 2026-04-03


class Solution:
    def getModifiedArray(self, length: int, updates: List[List[int]]) -> List[int]:
        arr = [0] * (length + 1)
        for left, right, inc in updates:
            arr[left] += inc
            arr[right + 1] -= inc
        sum = 0
        res = [0] * length
        for i in range(length):
            sum += arr[i]
            res[i] = sum
        return res

