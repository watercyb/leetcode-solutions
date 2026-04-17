#
# Problem: 1451. Rearrange Words in a Sentence
# Difficulty: Medium
# Link: https://leetcode.com/problems/rearrange-words-in-a-sentence/
# Language: python3
# Date: 2026-04-17


class Solution:
    def arrangeWords(self, text: str) -> str:
        strs = text.split(" ")
        strs[0] = strs[0].lower()
        strs.sort(key=lambda x: len(x))
        strs[0] = strs[0][0].capitalize() + strs[0][1:]
        return " ".join(strs)

