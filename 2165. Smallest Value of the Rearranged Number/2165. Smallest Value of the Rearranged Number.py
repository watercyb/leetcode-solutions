#
# Problem: 2165. Smallest Value of the Rearranged Number
# Difficulty: Medium
# Link: https://leetcode.com/problems/smallest-value-of-the-rearranged-number/
# Language: python3
# Date: 2026-04-24


class Solution:
    def smallestNumber(self, num: int) -> int:
        if num < 0:
            num = -num
            counts = [0] * 10
            while num > 0:
                counts[num % 10] += 1
                num //= 10
            idx = 9
            res = 0
            while idx >= 0:
                for _ in range(counts[idx]):
                    res = res * 10 + idx
                idx -= 1
            return -res
        elif num > 0:
            counts = [0] * 10
            while num > 0:
                counts[num % 10] += 1
                num //= 10
            idx = 1
            while counts[idx] == 0:
                idx += 1
            res = idx
            counts[idx] -= 1
            for _ in range(counts[0]):
                res *= 10
            while idx < 10:
                for _ in range(counts[idx]):
                    res = res * 10 + idx
                idx += 1
            return res
        else:
            return 0

