#
# Problem: 1999. Smallest Greater Multiple Made of Two Digits
# Difficulty: Medium
# Link: https://leetcode.com/problems/smallest-greater-multiple-made-of-two-digits/
# Language: python3
# Date: 2026-04-22


class Solution:
    def findInteger(self, k: int, digit1: int, digit2: int) -> int:
        if digit1 == 0 and digit2 == 0:
            return -1
        res = (1 << 31) - 1

        def dfs(num: int):
            nonlocal res
            if num > k:
                if num >= res:
                    return
                if num % k == 0:
                    res = num
                    return
            dfs(num * 10 + digit1)
            dfs(num * 10 + digit2)

        if digit1 != 0:
            dfs(digit1)
        if digit2 != 0:
            dfs(digit2)
        if res == (1 << 31) - 1:
            return -1
        return res

