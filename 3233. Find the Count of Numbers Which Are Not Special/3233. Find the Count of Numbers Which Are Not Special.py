#
# Problem: 3233. Find the Count of Numbers Which Are Not Special
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-the-count-of-numbers-which-are-not-special/
# Language: python3
# Date: 2026-05-05


class Solution:
    def nonSpecialCount(self, l: int, r: int) -> int:
        lim = int(sqrt(r))
        primes = [True] * (lim + 1)
        res = r - l + 1
        for i in range(2, lim + 1):
            if primes[i]:
                if i * i >= l:
                    res -= 1
                for j in range(i * 2, lim + 1, i):
                    primes[j] = False
        return res

