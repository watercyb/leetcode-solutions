#
# Problem: 3121. Count the Number of Special Characters II
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-the-number-of-special-characters-ii/
# Language: python3
# Date: 2026-05-04


class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        status = [0] * 26
        for char in word:
            if ord(char) < ord("a"):
                idx = ord(char) - ord("A")
                if status[idx] == 1 or status[idx] == 2:
                    status[idx] = 2
                else:
                    status[idx] = -1
            else:
                idx = ord(char) - ord("a")
                if status[idx] == 0 or status[idx] == 1:
                    status[idx] = 1
                else:
                    status[idx] = -1
        res = 0
        for st in status:
            if st == 2:
                res += 1
        return res

