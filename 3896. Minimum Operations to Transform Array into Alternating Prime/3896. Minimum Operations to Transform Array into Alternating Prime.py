#
# Problem: 3896. Minimum Operations to Transform Array into Alternating Prime
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-operations-to-transform-array-into-alternating-prime/
# Language: python3
# Date: 2026-04-15


isPrimes = [True] * 100004
primes = []
isPrimes[0] = isPrimes[1] = False
for i in range(2, 100004):
    if isPrimes[i]:
        for j in range(i * i, len(isPrimes), i):
            isPrimes[j] = False
        primes.append(i)

class Solution:
    def minOperations(self, nums: list[int]) -> int:
        res = 0
        idx = 0
        for num in nums:
            if idx == 0:
                if not isPrimes[num]:
                    index = bisect.bisect_left(primes, num)
                    res += primes[index] - num
            else:
                if isPrimes[num]:
                    if num == 2:
                        res += 2
                    else:
                        res += 1
            idx = 1 - idx
        return res

