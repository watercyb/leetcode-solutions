#
# Problem: 1471. The k Strongest Values in an Array
# Difficulty: Medium
# Link: https://leetcode.com/problems/the-k-strongest-values-in-an-array/
# Language: python3
# Date: 2026-04-17


class Solution:
    def getStrongest(self, arr: List[int], k: int) -> List[int]:
        arr.sort()
        target = arr[(len(arr) - 1) // 2]
        left = 0
        right = len(arr) - 1
        res = []
        for _ in range(k):
            if arr[right] - target >= target - arr[left]:
                res.append(arr[right])
                right -= 1
            else:
                res.append(arr[left])
                left += 1
        return res

