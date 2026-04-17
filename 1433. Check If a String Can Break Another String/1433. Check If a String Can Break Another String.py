#
# Problem: 1433. Check If a String Can Break Another String
# Difficulty: Medium
# Link: https://leetcode.com/problems/check-if-a-string-can-break-another-string/
# Language: python3
# Date: 2026-04-17


class Solution:
    def checkIfCanBreak(self, s1: str, s2: str) -> bool:
        h = 0
        chrs1 = list(s1)
        chrs2 = list(s2)
        chrs1.sort()
        chrs2.sort()
        for i in range(len(chrs1)):
            if chrs1[i] > chrs2[i]:
                h |= 1
            elif chrs1[i] < chrs2[i]:
                h |= 2
        return h != 3

