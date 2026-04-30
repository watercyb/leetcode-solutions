#
# Problem: 2761. Prime Pairs With Target Sum
# Difficulty: Medium
# Link: https://leetcode.com/problems/prime-pairs-with-target-sum/
# Language: python3
# Date: 2026-04-30


MAX_N = 10**6
isPrimes = [True] * (MAX_N + 1)
isPrimes[0:2] = [False, False]
for i in range(2, int(MAX_N**0.5) + 1):
    if isPrimes[i]:
        isPrimes[i * i : MAX_N + 1 : i] = [False] * ((MAX_N - i * i) // i + 1)

all_primes = [i for i, prime in enumerate(isPrimes) if prime]


class Solution:
    def findPrimePairs(self, n: int) -> List[List[int]]:
        res = []
        for a in all_primes:
            b = n - a
            if a > b:
                break
            if isPrimes[b]:
                res.append([a, b])
        return res

