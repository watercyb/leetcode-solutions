#
# Problem: 2951. Find the Peaks
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-the-peaks/
# Language: python3
# Date: 2026-05-02


class Solution:
    def findPeaks(self, mountain: List[int]) -> List[int]:
        res = []
        for i in range(1,len(mountain) - 1):
            if (mountain[i - 1] < mountain[i]) and (mountain[i] > mountain[i + 1]):
                res.append(i)
        return res

