#
# Problem: 3918. Sum of Primes Between Number and Its Reverse
# Difficulty: Medium
# Link: https://leetcode.com/problems/sum-of-primes-between-number-and-its-reverse/
# Language: python3
# Date: 2026-05-05


class Solution:
    def sumOfPrimesInRange(self, n: int) -> int:
        l = n
        r = 0
        while n > 0:
            r = r * 10 + n % 10
            n //= 10
        if r < l:
            temp = l
            l = r
            r = temp
        primes = [True] * (r + 1)
        primes[0] = primes[1] = False
        for i in range(2, r + 1):
            if primes[i]:
                for j in range(i * i, r + 1, i):
                    primes[j] = False
        res = 0
        for i in range(l, r + 1):
            if primes[i]:
                res += i
        return res

