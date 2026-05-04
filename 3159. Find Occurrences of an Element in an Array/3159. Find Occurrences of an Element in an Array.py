#
# Problem: 3159. Find Occurrences of an Element in an Array
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/
# Language: python3
# Date: 2026-05-04


class Solution:
    def occurrencesOfElement(
        self, nums: List[int], queries: List[int], x: int
    ) -> List[int]:
        arr = []
        for i in range(len(nums)):
            if nums[i] == x:
                arr.append(i)
        res = []
        for query in queries:
            query -= 1
            if query >= len(arr):
                res.append(-1)
            else:
                res.append(arr[query])
        return res

