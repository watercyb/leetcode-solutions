#
# Problem: 524. Longest Word in Dictionary through Deleting
# Difficulty: Medium
# Link: https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
# Language: python3
# Date: 2026-04-03


class Solution:
    def findLongestWord(self, s: str, dictionary: List[str]) -> str:
        dictionary = sorted(dictionary, key=lambda x: (-len(x), x))
        for st in dictionary:
            idx = 0
            for j in range(len(s)):
                if st[idx] == s[j]:
                    idx += 1
                    if idx == len(st):
                        return st
        return ""

