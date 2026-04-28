#
# Problem: 2521. Distinct Prime Factors of Product of Array
# Difficulty: Medium
# Link: https://leetcode.com/problems/distinct-prime-factors-of-product-of-array/
# Language: python3
# Date: 2026-04-28


class Solution:
    def distinctPrimeFactors(self, nums: List[int]) -> int:
        st = set(nums)
        primes = [True] * (max(nums) + 1)
        res = 0
        for i in range(2, max(nums) + 1):
            if not primes[i]:
                continue
            count = 0
            if i in st:
                count = 1
            for j in range(2 * i, max(nums) + 1, i):
                primes[j] = False
                if j in st:
                    count = 1
            res += count
        return res

