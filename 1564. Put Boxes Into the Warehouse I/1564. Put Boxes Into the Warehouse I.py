#
# Problem: 1564. Put Boxes Into the Warehouse I
# Difficulty: Medium
# Link: https://leetcode.com/problems/put-boxes-into-the-warehouse-i/
# Language: python3
# Date: 2026-04-18


class Solution:
    def maxBoxesInWarehouse(self, boxes: List[int], warehouse: List[int]) -> int:
        boxes.sort(reverse=True)
        res = 0
        idx = 0
        for h in boxes:
            if h <= warehouse[idx]:
                res += 1
                idx += 1
                if idx == len(warehouse):
                    break
                if warehouse[idx] > warehouse[idx - 1]:
                    warehouse[idx] = warehouse[idx - 1]
        return res

