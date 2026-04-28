#
# Problem: 2531. Make Number of Distinct Characters Equal
# Difficulty: Medium
# Link: https://leetcode.com/problems/make-number-of-distinct-characters-equal/
# Language: python3
# Date: 2026-04-28


class Solution:
    def isItPossible(self, word1: str, word2: str) -> bool:
        count_1 = Counter(word1)
        count_2 = Counter(word2)
        for i in range(ord("a"), ord("z") + 1):
            char_1 = chr(i)
            if count_1[char_1] == 0:
                continue
            for j in range(ord("a"), ord("z") + 1):
                char_2 = chr(j)
                if count_2[char_2] == 0:
                    continue
                a = len(count_1)
                b = len(count_2)
                if i != j:
                    if count_1[char_1] == 1:
                        a -= 1
                    if count_2[char_1] == 0:
                        b += 1
                    if count_1[char_2] == 0:
                        a += 1
                    if count_2[char_2] == 1:
                        b -= 1
                if a == b:
                    return True
        return False

