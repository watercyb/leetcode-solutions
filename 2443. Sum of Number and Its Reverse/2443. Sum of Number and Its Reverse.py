#
# Problem: 2443. Sum of Number and Its Reverse
# Difficulty: Medium
# Link: https://leetcode.com/problems/sum-of-number-and-its-reverse/
# Language: python3
# Date: 2026-04-27


class Solution:
    def sumOfNumberAndReverse(self, num: int) -> bool:
        for i in range(num // 2, num + 1):
            if i + int(str(i)[::-1]) == num:
                return True
        return False

