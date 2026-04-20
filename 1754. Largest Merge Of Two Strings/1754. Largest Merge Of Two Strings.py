#
# Problem: 1754. Largest Merge Of Two Strings
# Difficulty: Medium
# Link: https://leetcode.com/problems/largest-merge-of-two-strings/
# Language: python3
# Date: 2026-04-20


class Solution:
    def largestMerge(self, word1: str, word2: str) -> str:
        res = []
        i = 0
        j = 0
        while i < len(word1) and j < len(word2):
            if word1[i] < word2[j]:
                res.append(word2[j])
                j += 1
            elif word1[i] > word2[j]:
                res.append(word1[i])
                i += 1
            elif word1[i:] < word2[j:]:
                res.append(word2[j])
                j += 1
            else:
                res.append(word1[i])
                i += 1
        while i < len(word1):
            res.append(word1[i])
            i += 1
        while j < len(word2):
            res.append(word2[j])
            j += 1
        return "".join(res)

