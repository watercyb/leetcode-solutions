#
# Problem: 2063. Vowels of All Substrings
# Difficulty: Medium
# Link: https://leetcode.com/problems/vowels-of-all-substrings/
# Language: python3
# Date: 2026-04-23


class Solution:
    def countVowels(self, word: str) -> int:
        res = 0
        length = len(word)
        for i in range(length):
            if word[i] in "aeiou":
                res += (i + 1) * (length - i)
        return res

