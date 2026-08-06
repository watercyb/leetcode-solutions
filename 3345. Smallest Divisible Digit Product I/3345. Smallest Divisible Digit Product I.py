#
# Problem: 3345. Smallest Divisible Digit Product I
# Difficulty: Easy
# Link: https://leetcode.com/problems/smallest-divisible-digit-product-i/?envType=daily-question&envId=2026-08-06
# Language: python3
# Date: 2026-08-06


class Solution:
    def smallestNumber(self, n: int, t: int) -> int:
        while True:
            num = n
            p = 1
            while num > 0:
                p *= num % 10
                num //= 10
            if p % t == 0:
                return n
            n += 1

