#
# Problem: 2957. Remove Adjacent Almost-Equal Characters
# Difficulty: Medium
# Link: https://leetcode.com/problems/remove-adjacent-almost-equal-characters/
# Language: python3
# Date: 2026-05-02


class Solution:
    def removeAlmostEqualCharacters(self, word: str) -> int:
        res = 0
        idx = 1
        while idx < len(word):
            if abs(ord(word[idx]) - ord(word[idx - 1])) <= 1:
                res += 1
                idx += 2
            else:
                idx += 1
        return res

