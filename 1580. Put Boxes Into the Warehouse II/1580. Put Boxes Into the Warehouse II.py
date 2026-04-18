#
# Problem: 1580. Put Boxes Into the Warehouse II
# Difficulty: Medium
# Link: https://leetcode.com/problems/put-boxes-into-the-warehouse-ii/
# Language: python3
# Date: 2026-04-18


class Solution:
    def maxBoxesInWarehouse(self, boxes: List[int], warehouse: List[int]) -> int:
        left = 0
        right = len(warehouse) - 1
        boxes.sort(reverse=True)
        res = 0
        for box in boxes:
            if left <= right:
                if warehouse[left] >= box:
                    res += 1
                    left += 1
                elif warehouse[right] >= box:
                    res += 1
                    right -= 1
        return res

