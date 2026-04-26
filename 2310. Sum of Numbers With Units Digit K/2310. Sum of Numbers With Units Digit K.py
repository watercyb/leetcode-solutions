#
# Problem: 2310. Sum of Numbers With Units Digit K
# Difficulty: Medium
# Link: https://leetcode.com/problems/sum-of-numbers-with-units-digit-k/
# Language: python3
# Date: 2026-04-26


class Solution:
    def minimumNumbers(self, num: int, k: int) -> int:
        if num == 0:
            return 0
        for i in range(1, 11):
            if i * k % 10 == num % 10:
                if i * k <= num:
                    return i
                return -1
        return -1

