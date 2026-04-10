#
# Problem: 969. Pancake Sorting
# Difficulty: Medium
# Link: https://leetcode.com/problems/pancake-sorting/
# Language: python3
# Date: 2026-04-10


class Solution:
    def pancakeSort(self, arr: List[int]) -> List[int]:
        res = []
        while len(arr) > 1:
            max_val = arr[0]
            max_idx = 0
            for i in range(1, len(arr)):
                if arr[i] > max_val:
                    max_val = arr[i]
                    max_idx = i
            if max_idx == len(arr) - 1:
                arr.pop()
            else:
                res.append(max_idx + 1)
                res.append(len(arr))
                arr_next = []
                for i in range(len(arr) - 1, max_idx, -1):
                    arr_next.append(arr[i])
                for i in range(0, max_idx):
                    arr_next.append(arr[i])
                arr = arr_next
        return res

