#
# Problem: 1419. Minimum Number of Frogs Croaking
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-number-of-frogs-croaking/
# Language: python3
# Date: 2026-04-17


class Solution:
    def minNumberOfFrogs(self, croakOfFrogs: str) -> int:
        c = r = o = a = k = 0
        res = 0
        for chr in croakOfFrogs:
            match chr:
                case "c":
                    if k == 0:
                        res += 1
                    else:
                        k -= 1
                    c += 1
                case "r":
                    if c == 0:
                        return -1
                    c -= 1
                    r += 1
                case "o":
                    if r == 0:
                        return -1
                    r -= 1
                    o += 1
                case "a":
                    if o == 0:
                        return -1
                    o -= 1
                    a += 1
                case _:
                    if a == 0:
                        return -1
                    a -= 1
                    k += 1
        if c != 0 or r != 0 or o != 0 or a != 0:
            return -1
        return res

