#
# Problem: 4115. Sum of Compatible Numbers in Range II
# Difficulty: Hard
# Link: https://leetcode.com/problems/sum-of-compatible-numbers-in-range-ii/
# Language: python3
# Date: 2026-11-20


class Solution:
    def sumOfGoodIntegers(self, n: int, k: int) -> int:
        a = self.getCount(n, n + k)
        b = self.getCount(n, n - k - 1)
        return (a - b) % 1_000_000_007

    def getCount(self, n: int, lim: int) -> int:
        if lim <= 0:
            return 0
        a = []
        for s in format(lim, "b"):
            if s == "0":
                a.append(0)
            else:
                a.append(1)
        b = [0] * len(a)
        num = n
        for i in range(len(a) - 1, -1, -1):
            b[i] = num & 1
            num >>= 1
        isGood = True
        num = 0
        count = 0
        res = 0
        for i in range(len(a)):
            res <<= 1
            if b[i] == 0:
                res = res * 2 + count
                count *= 2
            if i > 0 and b[i] == 0:
                count += 1
                res += 1
            if i > 0 and isGood and a[i] == 1:
                count += 1
                res += num << 1
            if a[i] == 1 and b[i] == 1:
                isGood = False
            num = (num << 1) + a[i]
        if isGood:
            count += 1
            res += lim
        return res

