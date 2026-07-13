#
# Problem: 3983. Subsequence After One Replacement
# Difficulty: Medium
# Link: https://leetcode.com/problems/subsequence-after-one-replacement/
# Language: python3
# Date: 2026-07-13


class Solution:
    def canMakeSubsequence(self, s: str, t: str) -> bool:
        lefts = [1000000] * len(s)
        left = -1
        i = 0
        for j in range(len(t)):
            lefts[i] = left
            if s[i] == t[j]:
                left = j
                i += 1
                if i == len(s) - 1:
                    if j < len(t) - 1:
                        return True
                if i == len(s):
                    break
        i = len(s) - 1
        right = len(s)
        for j in range(len(t) - 1, -1, -1):
            if right > lefts[i] + 1:
                return True
            if s[i] == t[j]:
                right = j
                i -= 1
                if i == 0:
                    if j > 0:
                        return True
                if i < 0:
                    break
        return False

