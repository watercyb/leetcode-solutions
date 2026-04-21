#
# Problem: 1849. Splitting a String Into Descending Consecutive Values
# Difficulty: Medium
# Link: https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/
# Language: python3
# Date: 2026-04-21


class Solution:
    def splitString(self, s: str) -> bool:

        def dfs(i: int, prv: int) -> bool:
            if i == len(s):
                return True
            num = ord(s[i]) - ord("0")
            i += 1
            if num == prv - 1 and dfs(i, num):
                return True
            while i < len(s) and num <= prv - 1:
                num = num * 10 + ord(s[i]) - ord("0")
                i += 1
                if num == prv - 1 and dfs(i, num):
                    return True
            return False

        num = 0
        lim = pow(10, len(s) / 2)
        for i in range(len(s) - 1):
            num = num * 10 + ord(s[i]) - ord("0")
            if num >= lim:
                break
            if dfs(i + 1, num):
                return True
        return False

