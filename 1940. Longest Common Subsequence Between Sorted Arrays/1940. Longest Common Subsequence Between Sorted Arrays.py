#
# Problem: 1940. Longest Common Subsequence Between Sorted Arrays
# Difficulty: Medium
# Link: https://leetcode.com/problems/longest-common-subsequence-between-sorted-arrays/
# Language: python3
# Date: 2026-04-22


class Solution:
    def longestCommonSubsequence(self, arrays: List[List[int]]) -> List[int]:
        counts = [0] * 101
        for arr in arrays:
            for num in arr:
                counts[num] += 1
        res = []
        for i in range(101):
            if counts[i] == len(arrays):
                res.append(i)
        return res

