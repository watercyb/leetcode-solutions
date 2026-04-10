#
# Problem: 984. String Without AAA or BBB
# Difficulty: Medium
# Link: https://leetcode.com/problems/string-without-aaa-or-bbb/
# Language: python3
# Date: 2026-04-10


class Solution:
    def strWithout3a3b(self, a: int, b: int) -> str:
        chrA = "a"
        chrB = "b"
        if a < b:
            temp = a
            a = b
            b = temp
            chrA = "b"
            chrB = "a"
        n = a // (b + 1)
        r = a % (b + 1)
        arr = []
        for _ in range(r):
            for _ in range(n + 1):
                arr.append(chrA)
            arr.append(chrB)
        for _ in range(r, b):
            for _ in range(n):
                arr.append(chrA)
            arr.append(chrB)
        for _ in range(n):
            arr.append(chrA)
        return "".join(arr)

