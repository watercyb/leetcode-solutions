#
# Problem: 738. Monotone Increasing Digits
# Difficulty: Medium
# Link: https://leetcode.com/problems/monotone-increasing-digits/
# Language: python3
# Date: 2026-04-08


class Solution:
    def monotoneIncreasingDigits(self, n: int) -> int:
        num = str(n)
        idx = 1
        while idx < len(num) and num[idx] >= num[idx - 1]:
            idx += 1
        if idx == len(num):
            return n
        idx -= 1
        while idx > 0 and num[idx] == num[idx - 1]:
            idx -= 1
        res = n // pow(10, len(num) - 1 - idx) - 1
        for _ in range(len(num) - 1 - idx):
            res = res * 10 + 9
        return res

